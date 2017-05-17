package com.example.www.android_club.signUp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;

import com.example.www.android_club.R;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 윤정현 on 2017-04-13.
 */

public class SignUpActivity extends AppCompatActivity {
    private AQuery aq;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_page);

    }


    public void loginBtnClicked(View v){

        final EditText idField = (EditText)findViewById(R.id.id);
        final String id = idField.getText().toString();
        final EditText pwField = (EditText)findViewById(R.id.password);
        final String password = pwField.getText().toString();

        aq = new AQuery(this);
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id",id);
        params.put("password",password);
        Toast.makeText(getApplicationContext(), id+","+password , Toast.LENGTH_SHORT).show();
                                                          /* ResulstType.class */
        aq.ajax("http://13.124.15.202:80/process/login", params, String.class, new AjaxCallback<String>(){
            @Override
            public void callback(String url, String response /* ResponseType responseValue */, AjaxStatus status)
            {
                int statusCode = status.getCode(); // status code
                switch(statusCode){
                    case 401:
                        Toast.makeText(getApplicationContext(),"Login failed", Toast.LENGTH_SHORT).show();
                        break;
                    case 200:
                        Toast.makeText(getApplicationContext(), "login succeed", Toast.LENGTH_SHORT).show();
                        break;
                    case 412:
                        Toast.makeText(getApplicationContext(), "아이디와 비밀번호는 꼭 입력되어야 합니다.", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

    }
}
