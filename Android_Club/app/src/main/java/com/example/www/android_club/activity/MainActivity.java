package com.example.www.android_club.activity;



import android.os.Bundle;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TableLayout;

import com.example.www.android_club.circleList.Club;
import com.example.www.android_club.main.Notice;
import com.example.www.android_club.main.NoticeListAdapter;
import com.example.www.android_club.myPage.ClubMyPageFragment;
import com.example.www.android_club.R;
import com.example.www.android_club.recruit.RecruitFragment;
import com.example.www.android_club.circleList.ClubListFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 윤정현 on 2017-05-20.
 */


public class MainActivity extends AppCompatActivity {

    private ListView noticeListView;
    private NoticeListAdapter adapter;
    private List<Notice> noticeList;
    private TabLayout tabLayout;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submain);

        noticeListView = (ListView) findViewById(R.id.noticeListView);
        noticeList = new ArrayList<Notice>();

        addListView(noticeListView, (ArrayList) noticeList);

        final Button clubListButton = (Button) findViewById(R.id.clubView);
        final Button clubMyButton = (Button) findViewById(R.id.CurrentMyPage);
        final Button clubIntro = (Button) findViewById(R.id.introCircleButton);
        final LinearLayout notice = (LinearLayout) findViewById(R.id.notice);

        Toolbar actionBarToolBar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(actionBarToolBar);
        actionBarToolBar.setNavigationIcon(R.drawable.ic_menu_black_24dp);

        tabLayout = (TabLayout) findViewById(R.id.mTab);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(new MyPageAdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);


    }



    public  void addListView(ListView listView, ArrayList arrayList){
        arrayList.add(new Notice("공지사항","윤정현","2017-05-21"));
        arrayList.add(new Notice("공지사항","윤정현","2017-05-22"));
        arrayList.add(new Notice("공지사항","윤정현","2017-05-23"));
        arrayList.add(new Notice("공지사항","윤정현","2017-05-24"));
        arrayList.add(new Notice("공지사항","윤정현","2017-05-25"));
        arrayList.add(new Notice("공지사항","윤태훈","2017-05-26"));
        arrayList.add(new Notice("공지사항","윤태훈","2017-05-27"));
        arrayList.add(new Notice("공지사항", "윤태훈", "2017-05-28"));
        arrayList.add(new Notice("공지사항", "윤태훈", "2017-05-29"));
        adapter = new NoticeListAdapter(getApplicationContext(), arrayList);
        listView.setAdapter(adapter);
    }

    private class MyPageAdapter extends FragmentPagerAdapter {
        public MyPageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return ClubListFragment.newInstance();
                case 1:
                    return ClubMyPageFragment.newInstance();
                case 2:
                    return ClubListFragment.newInstance();
                default:
                    return null;
            }


        }



        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "First";
                case 1:
                    return "second";
                case 2:
                    return "third";
                default:
                    return null;

            }
        }

    }





}
