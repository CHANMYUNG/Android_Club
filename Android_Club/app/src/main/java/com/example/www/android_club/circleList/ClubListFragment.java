/*
package com.example.www.android_club.circleList;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;
import com.example.www.android_club.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;


*/
/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ClubListFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ClubListFragment#newInstance} factory method to
 * create an instance of this fragment.
 *//*

public class ClubListFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private AQuery aq;
    private JSONArray circles;
    private ListView clubList;
    private ClubListAdapter adapter;
    private ArrayList<Club> clubs;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public ClubListFragment() {
        // Required empty public constructor\
        Log.d("******************","ClubListFragment()");
    }

    */
/**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ClubListFragment.
     *//*

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
      */
/*  aq = new AQuery(getActivity());

        Map<String, Object> params = new HashMap<>();
        aq.ajax("http://13.124.15.202:80/circle/getCircleInfos", params, String.class, new AjaxCallback<String>(){
            @Override
            public void callback(String url, String response *//*
*/
/* ResponseType responseValue *//*
*/
/*, AjaxStatus status)
            {
                Toast.makeText(getActivity(),response,Toast.LENGTH_SHORT).show();
                try {
                    JSONObject object = new JSONObject(response);
                    if(object.getBoolean("error")) {
                        Toast.makeText(getActivity(), "에러발생", Toast.LENGTH_SHORT).show();
                        return;
                    }else {
                        JSONArray circles = object.getJSONArray("infos");
                        for (int i = 0; i < circles.length(); i++) {
                            JSONObject circle = (JSONObject) circles.get(i);
                            clubs.add(new Club(R.drawable.dsmlogo, circle.getString("name"), circle.getString("leader"), circle.getInt("size")));
                        }
                    }
                } catch (JSONException e) {
                    Toast.makeText(getActivity(), "ERROR", Toast.LENGTH_SHORT).show();
                    Toast.makeText(getActivity(), e.getStackTrace().toString() , Toast.LENGTH_SHORT).show();
                }

            }
        });*//*

    }

    public ArrayList<Club> getCircles() {
        clubs=new ArrayList<>();
        aq = new AQuery(getActivity());
        Map<String, Object> params = new HashMap<>();
        aq.ajax("http://13.124.15.202:80/circle/getCircleInfos", params, String.class, new AjaxCallback<String>(){
            @Override
            public void callback(String url, String response  */
/*ResponseType responseValue*//*
 , AjaxStatus status)
            {
                Toast.makeText(getActivity(),response,Toast.LENGTH_SHORT).show();
                try {
                    JSONObject object = new JSONObject(response);
                    if(object.getBoolean("error")) {
                        Toast.makeText(getActivity(), "에러발생", Toast.LENGTH_SHORT).show();
                        return;
                    }else {
                        JSONArray circles = object.getJSONArray("infos");
                        for (int i = 0; i < circles.length(); i++) {
                            JSONObject circle = (JSONObject) circles.get(i);
                            clubs.add(new Club(R.drawable.dsmlogo, circle.getString("name"), circle.getString("leader"), ((JSONObject) circles.get(i)).getInt("size")));
                        }
                    }
                } catch (JSONException e) {
                    Toast.makeText(getActivity(), "ERROR", Toast.LENGTH_SHORT).show();
                    Toast.makeText(getActivity(), e.getStackTrace().toString() , Toast.LENGTH_SHORT).show();
                }

            }
        });
        return clubs;
    }


    private ClubListAdapter clubListAdapter;
    private ArrayList<Club> saveItems=new ArrayList<>();
    private View v;
    private ArrayList<Club> items;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_circlelist,container,false);
        circleList(v);
        doSearch(v);

        return v;
    }

    private void doSearch(View v){
        final EditText circleSearchEditText=(EditText)v.findViewById(R.id.searchCircleEdit);

        circleSearchEditText.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String text=circleSearchEditText.getText().toString().toLowerCase(Locale.getDefault());
                filter(text);
            }
        });
    }

    private  void circleList(View v){
        items= new ArrayList<>();
        aq = new AQuery(getActivity());
        clubList=(ListView) v.findViewById(R.id.clubListView);
        Map<String, Object> params = new HashMap<>();
        aq.ajax("http://13.124.15.202:80/circle/getCircleInfos", params, String.class, new AjaxCallback<String>(){
            @Override
            public void callback(String url, String response  */
/*ResponseType responseValue*//*
 , AjaxStatus status)
            {
                Toast.makeText(getActivity(),response,Toast.LENGTH_SHORT).show();
                try {
                    JSONObject object = new JSONObject(response);
                    if(object.getBoolean("error")) {
                        //Toast.makeText(getActivity(), "에러발생", Toast.LENGTH_SHORT).show();
                        return;
                    }else {
                        JSONArray circles = object.getJSONArray("infos");

                        for (int i = 0; i < circles.length(); i++) {

                            JSONObject circle = (JSONObject) circles.get(i);
                            String name=circle.getString("name");
                            String leader=circle.getString("leader");
                            int size=circle.getInt("size");
                            items.add(new Club(R.drawable.dsmlogo,name,leader,size));
                        }
                        clubListAdapter=new ClubListAdapter(getActivity().getApplicationContext(),R.id.notice,items);
                        clubList.setAdapter(clubListAdapter);
                    }
                } catch (JSONException e) {
                    Toast.makeText(getActivity(), "ERROR", Toast.LENGTH_SHORT).show();
                    Toast.makeText(getActivity(), e.getStackTrace().toString() , Toast.LENGTH_SHORT).show();
                }

            }
        });
        saveItems.addAll(items); //검색을 위한 리스트

        //clubListAdapter=new ClubListAdapter(getActivity().getApplicationContext(),R.id.noticeitem,items);
        //clubList.setAdapter(clubListAdapter);
    }

    public void filter(String searchText){
        saveItems.clear();
        if(searchText.length()==0){
            saveItems.addAll(items);
        }else{
            for(Club club:items){
                if(club.getClubName().toLowerCase(Locale.getDefault()).contains(searchText)){
                    saveItems.add(club);
                }
            }

            clubListAdapter.clubList = saveItems;
        }
        clubListAdapter.notifyDataSetChanged();
    }




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

    */
/**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     *//*

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
*/
