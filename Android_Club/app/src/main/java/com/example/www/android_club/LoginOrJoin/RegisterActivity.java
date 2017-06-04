package com.example.www.android_club.LoginOrJoin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.androidquery.AQuery;
import com.example.www.android_club.R;

/**
 * Created by 윤정현 on 2017-05-19.
 */

public class RegisterActivity extends AppCompatActivity {

    private ArrayAdapter adapter;
    private Spinner spinner;
    AQuery aq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        EditText idEditText=(EditText)findViewById(R.id.joinId);
        EditText passwordEditText=(EditText)findViewById(R.id.joinPassword);
        EditText emailEditText=(EditText)findViewById(R.id.joinEmail);
        EditText serialKeyEditText=(EditText)findViewById(R.id.serialKey);
        TextView backloginView=(TextView)findViewById(R.id.backLoginView);

        Button joinRegisterButton=(Button)findViewById(R.id.registerButton);

        joinRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        backloginView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(RegisterActivity.this,LoginActivity.class);
                RegisterActivity.this.startActivity(intent);
                finish();
            }
        });





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