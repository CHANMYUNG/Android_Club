package com.example.www.android_club.Scheduling;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import android.widget.ImageButton;


import com.example.www.android_club.R;
import com.example.www.android_club.myPage.myPage_o;

/**
 * Created by 윤정현 on 2017-05-15.
 */
public class ClubSchedulingActivity extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scheduling);


        Button button =(Button)findViewById(R.id.back_plan);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), myPage_o.class);
                startActivity(intent);
            }
        });

    }
}
