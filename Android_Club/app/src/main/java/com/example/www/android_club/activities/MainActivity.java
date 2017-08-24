package com.example.www.android_club.activities;


import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
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
        layoutManager=new LinearLayoutManager(this);


        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new MainAdapter(this,getMainList()));


    }

    public ArrayList<String> getMainList(){
        mainList=new ArrayList<>();

        mainList.add("동아리 관리");
        mainList.add("동아리 모집");
        mainList.add("마이 페이지");

        return  mainList;
    }






}
