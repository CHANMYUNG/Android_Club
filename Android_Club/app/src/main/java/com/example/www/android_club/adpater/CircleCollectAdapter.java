package com.example.www.android_club.adpater;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.SparseArray;

import com.example.www.android_club.circleList.Club;
import com.example.www.android_club.fragments.CircleCollectFragment;

import java.util.ArrayList;

/**
 * Created by 윤정현 on 2017-09-07.
 */

public class CircleCollectAdapter extends FragmentStatePagerAdapter {

    private ArrayList<Club> arrayList;
    private SparseArray<CircleCollectFragment> fragments;

    public CircleCollectAdapter(FragmentManager fm, ArrayList<Club> arrayList){
        super(fm);
        this.arrayList=arrayList;
    }

    @Override
    public Fragment getItem(int position) {
        CircleCollectFragment circleCollectFragment=new CircleCollectFragment();


        return null;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }
}
