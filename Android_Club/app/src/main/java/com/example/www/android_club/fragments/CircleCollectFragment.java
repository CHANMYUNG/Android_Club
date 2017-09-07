package com.example.www.android_club.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.www.android_club.R;

public class CircleCollectFragment extends Fragment {
    public CircleCollectFragment() {
        // Required empty public constructor
    }

    public static CircleCollectFragment newInstance(String param1, String param2) {
        CircleCollectFragment fragment = new CircleCollectFragment();
        Bundle args = new Bundle();
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
