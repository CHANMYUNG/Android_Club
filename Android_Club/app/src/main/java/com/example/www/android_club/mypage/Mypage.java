package com.example.www.android_club.mypage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.www.android_club.MainActivity;
import com.example.www.android_club.R;

/**
 * Created by mac on 2017. 4. 12..
 */

public class Mypage extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);


        setContentView(R.layout.mypage_club_x);
        ImageButton btn = (ImageButton)findViewById(R.id.goMain);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                        // layout change
                switch (v.getId()){
                    case R.id.goMain:
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        break;
                }

            }
        });

    }


}

