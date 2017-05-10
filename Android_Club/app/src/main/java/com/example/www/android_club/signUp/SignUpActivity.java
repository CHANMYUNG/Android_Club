package com.example.www.android_club.signUp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
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

        final EditText idField = (EditText)findViewById(R.id.id);
        final EditText pwField = (EditText)findViewById(R.id.password);

        final String requestURL = "http://localhost:8080/process/login";
        StringRequest request = new StringRequest(Request.Method.POST, requestURL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            switch (response) {
                                case "Succeed":
                                    Toast.makeText(getApplicationContext(), "Login Succeed!!!", Toast.LENGTH_LONG).show();
                                    break;
                                case "The name already exists":
                                    Toast.makeText(getApplicationContext(), "The name already exists...", Toast.LENGTH_LONG).show();
                                    break;
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "Error Occured", Toast.LENGTH_LONG).show();
                    }
                }
        ) {

            @Override
            public Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("id", idField.getText().toString());
                params.put("password", pwField.getText().toString());

                return params;
            }
        };
        request.setShouldCache(false);
        Volley.newRequestQueue(this).add(request);
    }
}
