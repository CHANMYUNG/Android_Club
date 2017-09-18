package com.example.www.android_club.adpater;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.SparseArray;

import com.example.www.android_club.circleList.Club;
import com.example.www.android_club.fragments.CircleCollectFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 윤정현 on 2017-09-07.
 */

public class CircleCollectPagerAdapter extends FragmentStatePagerAdapter {

    public int position;
    private SparseArray<CircleCollectFragment> fragments;

    public CircleCollectPagerAdapter(FragmentManager fm){
        super(fm);
        fragments=new SparseArray<>();
    }

    @Override
    public Fragment getItem(int position) {
        CircleCollectFragment fragment=fragments.get(position);
        if(fragment==null){
            fragment=CircleCollectFragment.newInstance(position);
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 100;
    }
}
