package com.example.www.android_club;

import com.example.www.android_club.clubInfo.*;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.Toast;



import com.example.www.android_club.clubInfo.clubInfo;
import java.util.ArrayList;
import com.example.www.android_club.clubInfo.*;
import com.example.www.android_club.myPage.myPage_o;

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
        gridArray.add((new MainData("d안녕", resources.getDrawable(R.drawable.clubinfo_activity))));
        gridArray.add((new MainData("동아리", resources.getDrawable(R.drawable.clubinfo_member))));
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
                Intent intent=new Intent(getApplicationContext(),clubInfo.class);
                startActivity(intent);
            }
        });

        final EditText editText=(EditText)findViewById(R.id.edit);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String text=editText.getText().toString();
                gridAdapter.filter(text);
            }
        });
    }
    public void init(){

    }
}
