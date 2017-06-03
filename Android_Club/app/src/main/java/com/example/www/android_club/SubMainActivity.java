package com.example.www.android_club;


import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.www.android_club.clubList.ClubListFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 윤정현 on 2017-05-20.
 */


public class SubMainActivity extends AppCompatActivity {

    private ListView noticeListView;
    private NoticeListAdapter adapter;
    private List<Notice> noticeList;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submain);

        noticeListView=(ListView)findViewById(R.id.noticeListView);
        noticeList= new ArrayList<Notice>();

        addListView(noticeListView, (ArrayList) noticeList);


        final Button clubListButton=(Button)findViewById(R.id.clubView);
        final Button clubMyButton=(Button)findViewById(R.id.CurrentMyPage);
        final LinearLayout notice=(LinearLayout)findViewById(R.id.notice);

        clubListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notice.setVisibility(View.GONE); //공지사항뷰 안보이게
                FragmentManager fragmentManager=getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                clubMyButton.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));

                clubListButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                fragmentTransaction.replace(R.id.fragment, new ClubListFragment());
                fragmentTransaction.commit();
            }
        });

        clubMyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notice.setVisibility(View.GONE); //공지사항뷰 안보이게
                FragmentManager fragmentManager=getSupportFragmentManager();
                clubListButton.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                clubMyButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                fragmentTransaction.replace(R.id.fragment, new ClubMyPage());
                fragmentTransaction.commit();
            }
        });

    }

    public  void addListView(ListView listView, ArrayList arrayList){
        arrayList.add(new Notice("공지사항","윤정현","2017-05-21"));
        arrayList.add(new Notice("공지사항","윤정현","2017-05-22"));
        arrayList.add(new Notice("공지사항","윤정현","2017-05-23"));
        arrayList.add(new Notice("공지사항","윤정현","2017-05-24"));
        arrayList.add(new Notice("공지사항","윤정현","2017-05-25"));
        arrayList.add(new Notice("공지사항","윤태훈","2017-05-26"));
        arrayList.add(new Notice("공지사항","윤태훈","2017-05-27"));
        arrayList.add(new Notice("공지사항","윤태훈","2017-05-28"));
        arrayList.add(new Notice("공지사항","윤태훈","2017-05-29"));
        adapter= new NoticeListAdapter(getApplicationContext(),arrayList);
        listView.setAdapter(adapter);
    }




}
