package com.example.www.android_club.clubList;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.icu.lang.UCharacterEnums;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;
import com.example.www.android_club.ClubMyPage;
import com.example.www.android_club.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ClubListFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ClubListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ClubListFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private AQuery aq;
    private JSONArray circles;
    private ListView clubList;
    private ClubListAdapter adapter;
    private ArrayList<Club> clubs = new ArrayList<>();
    private Club club;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public ClubListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ClubListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ClubListFragment newInstance(String param1, String param2) {
        ClubListFragment fragment = new ClubListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


        aq = new AQuery(getActivity());
        Map<String, Object> params = new HashMap<>();
        aq.ajax("http://13.124.15.202:80/circle/getCircles", params, String.class, new AjaxCallback<String>(){
            @Override
            public void callback(String url, String response /* ResponseType responseValue */, AjaxStatus status)
            {
                try {
                    JSONObject object = new JSONObject(response);
                    if(object.getBoolean("error")) {
                        Toast.makeText(getActivity(), "에러발생", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    JSONArray circles = object.getJSONArray("circles");
                    for(int i = 0 ; i < circles.length(); i ++){
                        JSONObject circle = (JSONObject) circles.get(i);
                        clubs.add(new Club(R.drawable.dsmlogo, circle.getString("name"), Integer.toString(circle.getInt("leader")), circle.getInt("size")));
                    }

                    adapter= new ClubListAdapter(getActivity(),clubs);
                    clubList.setAdapter(adapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    public void addListView(ListView listView, ArrayList arrayList){

        adapter= new ClubListAdapter(getActivity(),getCircles());
        clubList.setAdapter(adapter);

    }

    private List<Club> getCircles() {
        aq = new AQuery(getActivity());
        Map<String, Object> params = new HashMap<>();
        aq.ajax("http://13.124.15.202:80/circle/getCircles", params, String.class, new AjaxCallback<String>(){
            @Override
            public void callback(String url, String response /* ResponseType responseValue */, AjaxStatus status)
            {
                try {
                    JSONObject object = new JSONObject(response);
                    if(object.getBoolean("error")) {
                        Toast.makeText(getActivity(), "에러발생", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    JSONArray circles = object.getJSONArray("circles");
                    for(int i = 0 ; i < circles.length(); i ++){
                        JSONObject circle = (JSONObject) circles.get(i);
                        Toast.makeText(getActivity(), circle.getString("name"), Toast.LENGTH_SHORT).show();
                        clubs.add(new Club(R.drawable.dsmlogo, circle.getString("name"), Integer.toString(circle.getInt("leader")), circle.getInt("size")));
                    }
                } catch (JSONException e) {
                    Toast.makeText(getActivity(), "ERROR", Toast.LENGTH_SHORT).show();
                    Toast.makeText(getActivity(), e.getStackTrace().toString() , Toast.LENGTH_SHORT).show();
                }
            }
        });
        clubs.add(new Club(R.drawable.dsmlogo, "시나브로", "강석직", 5));
        return clubs;
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v=inflater.inflate(R.layout.fragment_clublist,container,false);
        clubList=(ListView)v.findViewById(R.id.clubListView);
        addListView(clubList, (ArrayList) clubs);
        return v;
    }


    /*public void addItem(int icon,String clubName,String reader,int num){
        adapter
    }*/




    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
