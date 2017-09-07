package com.example.www.android_club.activities;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.www.android_club.R;

public class CircleCollectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_collect);
        setToolbar();
    }

    public void setToolbar(){
        ImageView tv_ib=(ImageView)findViewById(R.id.ib_toolbar_menu);
        tv_ib.setImageResource(R.drawable.back);

        TextView textView=(TextView)findViewById(R.id.tv_toolbar_title);
        textView.setText("동아리 모집");
    }
}
