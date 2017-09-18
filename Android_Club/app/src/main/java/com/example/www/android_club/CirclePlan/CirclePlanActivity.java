package com.example.www.android_club.circlePlan;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.www.android_club.R;

/**
 * Created by 윤정현 on 2017-06-05.
 */

public class CirclePlanActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planwrite);
        TextView textViewTitle=(TextView)findViewById(R.id.planTitle_1);
        TextView textViewWriter=(TextView)findViewById(R.id.planWriter_1);
        TextView textViewContent=(TextView)findViewById(R.id.planContent_1);
        Intent intent=getIntent();
        textViewTitle.setText(intent.getStringExtra("title"));
        textViewWriter.setText(intent.getStringExtra("writer"));
        textViewContent.setText(intent.getStringExtra("content"));
    }







}