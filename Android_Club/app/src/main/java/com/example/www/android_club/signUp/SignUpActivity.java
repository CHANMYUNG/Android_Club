package com.example.www.android_club.signUp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

<<<<<<< HEAD
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.www.android_club.MainActivity;
=======
import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;
>>>>>>> 8862f5b2e18fb7d88533e74b33f829b76b3fff14
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

<<<<<<< HEAD
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
=======
>>>>>>> 8862f5b2e18fb7d88533e74b33f829b76b3fff14

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
<<<<<<< HEAD
        };
        request.setShouldCache(false);
        Volley.newRequestQueue(this).add(request);

        Intent intent=new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
=======
        });

>>>>>>> 8862f5b2e18fb7d88533e74b33f829b76b3fff14
    }
}
