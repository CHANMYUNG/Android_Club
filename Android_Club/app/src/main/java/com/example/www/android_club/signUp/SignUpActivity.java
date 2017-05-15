package com.example.www.android_club.signUp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.www.android_club.HttpClient.Config;
import com.example.www.android_club.HttpClient.HttpClient;
import com.example.www.android_club.HttpClient.Response;
import com.example.www.android_club.R;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 윤정현 on 2017-04-13.
 */

public class SignUpActivity extends AppCompatActivity {
    
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_page);

    }


    public void loginBtnClicked(View v){

        Config config = new Config();
        config.setTargetAddress("http://127.0.0.1");
        config.setTargetPort(8080);

        final EditText idField = (EditText)findViewById(R.id.id);
        final String id = idField.getText().toString();
        final EditText pwField = (EditText)findViewById(R.id.password);
        final String password = pwField.getText().toString();
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);
        params.put("password", password);


        HttpClient httpClient = new HttpClient(config);
        Response response = httpClient.post("/process/login", new HashMap<String, Object>(), params);
        switch (response.getResponseBody()){
            case "Succeed":
                Toast.makeText(getApplicationContext(), "Succeed!!!", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
