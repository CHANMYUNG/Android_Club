package com.example.www.android_club.clubInfo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.www.android_club.R;

/**
 * Created by mac on 2017. 4. 12..
 */


public class clubInfo extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clubinfo);


    }

    public void info_buttonClicked(View v){
        switch(v.getId()){
            case R.id.btn_intro:
                // layout change
                Toast.makeText(this, "jhaha", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_activity:
                // layout change
                break;
            case R.id.btn_qna:
                // layout change
                break;
            case R.id.btn_member:
                // layout change
                break;
        }
    }
}
