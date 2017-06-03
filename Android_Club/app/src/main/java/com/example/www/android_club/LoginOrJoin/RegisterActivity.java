package com.example.www.android_club.LoginOrJoin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.www.android_club.R;

/**
 * Created by 윤정현 on 2017-05-19.
 */

public class RegisterActivity extends AppCompatActivity {

    private ArrayAdapter adapter;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

//        setSpinnerItemGrade(spinner);
//        setSpinnerItemClass(spinner);
//        setSpinnerItemClassNum(spinner);



    }

//    public void setSpinnerItemGrade(Spinner spinner){
//        spinner=(Spinner)findViewById(R.id.clubGrade);
//        adapter=ArrayAdapter.createFromResource(this,R.array.clubGrade,android.R.layout.simple_spinner_dropdown_item);
//        spinner.setAdapter(adapter);
//    }
//
//    public void setSpinnerItemClass(Spinner spinner){
//        spinner=(Spinner)findViewById(R.id.clubClass);
//        adapter=ArrayAdapter.createFromResource(this,R.array.clubClass,android.R.layout.simple_spinner_dropdown_item);
//        spinner.setAdapter(adapter);
//    }
//
//    public void setSpinnerItemClassNum(Spinner spinner){
//        spinner=(Spinner)findViewById(R.id.clubClassNum);
//        adapter=ArrayAdapter.createFromResource(this,R.array.clubClassNum,android.R.layout.simple_spinner_dropdown_item);
//        spinner.setAdapter(adapter);
//    }

}