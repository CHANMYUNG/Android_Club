package com.example.www.android_club;


import android.support.v4.app.FragmentManager;
import android.os.Bundle;
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

        final int checkNumClubList=1;
        final int checkNumMyList=2;
        final Button clubListButton=(Button)findViewById(R.id.clubView);
        final Button clubMyButton=(Button)findViewById(R.id.CurrentMyPage);
        final LinearLayout notice=(LinearLayout)findViewById(R.id.notice);

        fragmentChangeButton(clubListButton,notice,checkNumClubList);
        fragmentChangeButton(clubMyButton,notice,checkNumMyList);
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

    public void fragmentChangeButton(final Button button, final LinearLayout linearLayout, final int checkNum){ //프레그먼트를 바꾸는 버튼
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linearLayout.setVisibility(View.GONE); //공지사항뷰 안보이게
                button.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                button.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                FragmentManager fragmentManager=getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                if(checkNum==1){
                    fragmentTransaction.replace(R.id.fragment,new ClubListFragment());
                    fragmentTransaction.commit();
                }else if(checkNum ==2){
                    fragmentTransaction.replace(R.id.fragment,new ClubMyPage());
                    fragmentTransaction.commit(); //프래그먼트를 띄우기
                }
            }
        });
    }


}
