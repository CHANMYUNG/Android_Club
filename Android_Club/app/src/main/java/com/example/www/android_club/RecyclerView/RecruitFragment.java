package com.example.www.android_club.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.www.android_club.R;
import com.example.www.android_club.circleCreatePage.CircleCreateActivity;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link RecruitFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link RecruitFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RecruitFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public RecruitFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RecruitFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RecruitFragment newInstance(String param1, String param2) {
        RecruitFragment fragment = new RecruitFragment();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_recruit,container,false);
        RecyclerView recyclerView=(RecyclerView)v.findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager;
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<CircleData> items=new ArrayList<>();
        items.add(new CircleData("시나브로","1학년 2명 모집","2017-6-4",R.drawable.dsmlogo));
        items.add(new CircleData("시나브루","2학년 2명 모집","2017-6-5",R.drawable.dsmlogo));
        items.add(new CircleData("시나브롱","3학년 2명 모집","2017-6-6",R.drawable.dsmlogo));

        Button clubCreate=(Button)v.findViewById(R.id.createCircleCheck);

        clubCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), CircleCreateActivity.class);
                startActivity(intent);
            }
        });

        recyclerView.setAdapter(new RecyclerViewAdapter(getActivity(),items,R.layout.recruit_recyclertview_item));


        return v;
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
