package com.example.www.android_club.login;

/**
 * Created by 윤정현 on 2017-05-17.
 */

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;
import com.example.www.android_club.cookie.Cookie;
import com.example.www.android_club.R;
import com.example.www.android_club.activities.MainActivity;
import com.example.www.android_club.Join.RegisterActivity;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    private AQuery aq;
    Dialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);


        TextView joinView=(TextView)findViewById(R.id.registerButton);
        joinView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });

        final Button loginButton=(Button)findViewById(R.id.loginButton);
        final EditText editTextId=(EditText)findViewById(R.id.id);
        final EditText editTextPassword=(EditText)findViewById(R.id.password);


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = editTextId.getText().toString();
                String password = editTextPassword.getText().toString();

                if (id.length() == 0 || password.length() == 0) {
                    //아이디 비밀번호를 입력을 안한 경우
                    AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                    Dialog dialog = builder.setMessage("올바른 아이디 비밀번호을 입력 해주세요").setNegativeButton("다시시도", null).create();
                    dialog.show();
                } else {
                    // 정상적으로 입력한 경우
                    aq = new AQuery(loginButton);
                    Map<String, Object> params = new HashMap<>();
                    params.put("id", id);
                    params.put("password", password);
                    aq.ajax("http://13.124.15.202:80/account/activity_login", params, String.class, new AjaxCallback<String>() {

                        @Override
                        public void callback(String url, String response /* ResponseType responseValue */, AjaxStatus status) {
                            try {
                                List<Cookie> cookiesList;
                                JSONObject object = new JSONObject(response);
                                if (object.getBoolean("error")) {
                                    Toast.makeText(getApplicationContext(), "잠시후에 시도해주세요", Toast.LENGTH_SHORT).show();
                                    return;
                                } else {
                                    Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();
                                    if (object.getBoolean("success")) {

                                        AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                                        Dialog dialog = builder.setMessage("로그인에 성공했습니다").setPositiveButton("okay", null).create();
                                        dialog.show();
                                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);

                                        LoginActivity.this.startActivity(intent);
                                        finish(); //현재 액티비티 종료
                                    } else {
                                        //로그인 비밀번호 불일치
                                        AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                                        dialog = builder.setMessage("계정을 다시 확인 하세요").setNegativeButton("다시시도", null).create();
                                        dialog.show();
                                    }
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
            }
        });
    }

    @Override
    protected  void onStop(){
        super.onStop();
        if(dialog!=null){
            dialog.dismiss();
            dialog=null;
        }
    }



}
