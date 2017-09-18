package com.example.www.android_club.activities;

import android.media.Image;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.www.android_club.R;
import com.example.www.android_club.adpater.CircleCollectPagerAdapter;

public class CircleCollectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_collect);
        backButton();
        setToolbar();

        ViewPager viewPager =(ViewPager)findViewById(R.id.circle_collect_viewpager);
        viewPager.setAdapter(new CircleCollectPagerAdapter(getSupportFragmentManager()));

    }

    public void setToolbar(){
        ImageView tv_ib=(ImageView)findViewById(R.id.ib_toolbar_menu);
        tv_ib.setImageResource(R.drawable.ic_arrow_back_black_24dp);

        TextView textView=(TextView)findViewById(R.id.tv_toolbar_title);
        textView.setText("동아리 모집");
    }

    public void backButton(){
        ImageView imageView=(ImageView) findViewById(R.id.ib_toolbar_menu);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
