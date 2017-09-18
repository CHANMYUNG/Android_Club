package com.example.www.android_club.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.www.android_club.R;
import com.example.www.android_club.circleList.Club;

import java.util.ArrayList;

public class CircleCollectFragment extends Fragment {

    private static final String POSITION_KEY="position";
    public CircleCollectFragment() {
        // Required empty public constructor
    }

    public static CircleCollectFragment newInstance(int position) {

        Bundle args = new Bundle();
        args.putLong(POSITION_KEY,position);
        CircleCollectFragment fragment = new CircleCollectFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_circle_collect, container, false);
    }


}
