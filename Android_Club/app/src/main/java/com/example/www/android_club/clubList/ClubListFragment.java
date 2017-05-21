package com.example.www.android_club.clubList;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.example.www.android_club.R;

import java.util.ArrayList;
import java.util.List;


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

    private ListView clubList;
    private ClubListAdapter adapter;
    private List<Club> clubs;

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
    }

    public void addListView(ListView listView, ArrayList arrayList){
        arrayList.add(new Club(R.drawable.dsmlogo,"시나브로","강석직",5));
        arrayList.add(new Club(R.drawable.dsmlogo,"시나브로","강석직",6));
        arrayList.add(new Club(R.drawable.dsmlogo,"시나브로","강석직",7));
        arrayList.add(new Club(R.drawable.dsmlogo,"시나브로","강석직",8));
        adapter= new ClubListAdapter(getActivity(),arrayList);
        listView.setAdapter(adapter);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        clubList=(ListView)getView().findViewById(R.id.clubListView);
        clubs= new ArrayList<>();
        addListView(clubList,(ArrayList)clubs);
        return super.onCreateView(inflater,container,savedInstanceState);
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
