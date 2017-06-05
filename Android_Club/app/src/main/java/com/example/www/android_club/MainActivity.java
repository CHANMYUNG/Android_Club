package com.example.www.android_club;

import com.example.www.android_club.CirclePlan.CirclePlanActivity;
import com.example.www.android_club.clubInfo.*;
import android.content.Intent;
import android.content.res.Resources;
import android.support.annotation.BinderThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;



import com.example.www.android_club.clubInfo.clubInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

import com.example.www.android_club.clubInfo.*;
import com.example.www.android_club.myPage.myPage_o;

import butterknife.BindView;
import butterknife.BindViews;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
    List<MainData> gridArray=new ArrayList<MainData>();
    MainAdapter gridAdapter;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            //Resources resources = getResources();사진정보를 가져올때
            gridArray.add(new MainData("1사람","인원모집","2017-1021"));
            gridArray.add(new MainData("2사람","프로젝트준비","2017-1021"));
            gridArray.add(new MainData("3사람","역활분담","2017-1021"));
            gridArray.add(new MainData("4사람","공부","2017-1021"));
            //데이터베이스에서 들어온 데이터만큼 뿌려줄 예정

            gridView = (GridView) findViewById(R.id.gridview);
            gridAdapter = new MainAdapter(this, R.layout.activity_row, (ArrayList)gridArray);
            gridView.setAdapter(gridAdapter);


            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                    Toast.makeText(getApplicationContext(), gridArray.get(position).getText() + "  해당 index"+position, Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(MainActivity.this, CirclePlanActivity.class);
                    String writer=gridArray.get(position).getText();
                    String title=gridArray.get(position).getTitle();
                    String content=gridArray.get(position).getDate();
                    intent.putExtra("writer",writer);
                    intent.putExtra("content",content);
                    intent.putExtra("title",title);

                    startActivity(intent);
                }
            });
        }
}

