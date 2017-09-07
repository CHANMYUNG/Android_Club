package com.example.www.android_club.activities;


import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.www.android_club.DividerItemDecoration;
import com.example.www.android_club.adpater.MainAdapter;
import com.example.www.android_club.main.Notice;
import com.example.www.android_club.main.NoticeListAdapter;
import com.example.www.android_club.myPage.ClubMyPageFragment;
import com.example.www.android_club.R;
import com.example.www.android_club.recruit.RecruitFragment;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by 윤정현 on 2017-05-20.
 */


public class MainActivity extends AppCompatActivity {

    private ArrayList<String> mainList;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView recyclerView;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=(RecyclerView)findViewById(R.id.main_recyclerView);
        layoutManager=new GridLayoutManager(this,2);
        setToolbar();
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new MainAdapter(this));
    }

    public void setToolbar(){
        ImageView tv_ib=(ImageView)findViewById(R.id.ib_toolbar_menu);
        tv_ib.setImageResource(R.drawable.ic_menu_black_24dp);
    }







}
