package com.example.www.android_club;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.www.android_club.clubInfo.ClubInfo;
import com.example.www.android_club.myPage.myPage_o;
import com.example.www.android_club.myPage.myPage_x;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
    ArrayList<MainData> gridArray=new ArrayList<MainData>();
    MainAdapter gridAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources resources=getResources();
        gridArray.add((new MainData("동아리", resources.getDrawable(R.drawable.loading_page))));
        gridArray.add((new MainData("동아리", resources.getDrawable(R.drawable.loading_page))));
        gridArray.add((new MainData("동아리", resources.getDrawable(R.drawable.loading_page))));
        gridArray.add((new MainData("동아리", resources.getDrawable(R.drawable.loading_page))));
        gridArray.add((new MainData("동아리", resources.getDrawable(R.drawable.loading_page))));
        gridArray.add((new MainData("동아리", resources.getDrawable(R.drawable.loading_page))));
        gridArray.add((new MainData("동아리", resources.getDrawable(R.drawable.loading_page))));




        gridView=(GridView)findViewById(R.id.gridview);
        gridAdapter=new MainAdapter(this,R.layout.activity_row,gridArray);
        gridView.setAdapter(gridAdapter);


        ImageButton ib = (ImageButton)findViewById(R.id.mypageButton);
        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),myPage_o.class);
                startActivity(intent);
            }
        });

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent,View v,int position,long id){
                Toast.makeText(getApplicationContext(),""+position,Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(getApplicationContext(),ClubInfo.class);
                startActivity(intent);
            }
        });


    }
}
