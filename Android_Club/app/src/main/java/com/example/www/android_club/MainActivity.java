package com.example.www.android_club;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.www.android_club.mypage.Mypage;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
    ArrayList<MainData> girdArray=new ArrayList<MainData>();
    MainAdapter gridAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources resources=getResources();
        girdArray.add((new MainData("동아리", resources.getDrawable(R.drawable.aa))));



        gridView=(GridView)findViewById(R.id.gridview);
        gridAdapter=new MainAdapter(this,R.layout.activity_row,girdArray);
        gridView.setAdapter(gridAdapter);


        ImageButton ib = (ImageButton)findViewById(R.id.mypageButton);
        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Mypage.class);
                startActivity(intent);
            }
        });


    }
}
