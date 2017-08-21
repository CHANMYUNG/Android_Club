package com.example.www.android_club.circleCreatePage;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;
import com.example.www.android_club.R;
import com.example.www.android_club.activities.MainActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 윤정현 on 2017-06-03.
 */

public class CircleCreateActivity extends AppCompatActivity {
    private AQuery aq;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activty_circlefound);

        final Button createCircleButton = (Button) findViewById(R.id.createCircleButton);
        final EditText editTextCircleName = (EditText) findViewById(R.id.createCircleName);
        final EditText editTextCircleContent = (EditText) findViewById(R.id.createCircleContent);


        createCircleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AQuery checkCircleAQuery;
                aq = new AQuery(createCircleButton);

                String circleName = editTextCircleName.getText().toString();
                String circleContent = editTextCircleContent.getText().toString();

                Map<String, Object> params = new HashMap<>();
                params.put("circleName", circleName);
                params.put("circleContent", circleContent);
                aq.ajax("http://13.124.15.202:80/", params, String.class, new AjaxCallback<String>() {
                    @Override
                    public void callback(String url, String response, AjaxStatus status) {
                        try {
                            //status.getCode(); 상태코드에 따라 성공인지 아닌지 판단
                            JSONObject jsonObject = new JSONObject(response);
                            if (jsonObject.getBoolean("error")) {
                                //동아리 이미 등록됨
                            } else {
                                if (jsonObject.getBoolean("success")) {
                                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(CircleCreateActivity
                                            .this);
                                    Dialog dialog = alertDialog.setMessage("동아리 등록 성공").setPositiveButton("okay", null).create();
                                    dialog.show();
                                    Intent intent = new Intent(CircleCreateActivity.this, MainActivity.class);
                                    CircleCreateActivity.this.startActivity(intent);
                                    finish();

                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
    }
}
