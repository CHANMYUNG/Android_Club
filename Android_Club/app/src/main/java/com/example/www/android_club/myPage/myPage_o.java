package com.example.www.android_club.myPage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.www.android_club.MainActivity;
import com.example.www.android_club.R;
import com.example.www.android_club.Scheduling.ClubSchedulingActivity;
import com.example.www.android_club.memberList.memberListActivity;

import java.lang.reflect.Member;

/**
 * Created by 윤정현 on 2017-04-13.
 */

public class myPage_o extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mypage_club_o);

        CalendarView calendarView = (CalendarView) findViewById(R.id.calendar);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                Toast.makeText(myPage_o.this, "" + year + "/" + (month + 1) + "/" + dayOfMonth, 0).show();
                Intent intent=new Intent(getApplicationContext(), ClubSchedulingActivity.class);
                startActivity(intent);
            }
        });


        Button button = (Button) findViewById(R.id.next_memberList);
        button.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), memberListActivity.class);
                startActivity(intent);
            }
        });

        ImageButton backButton= (ImageButton)findViewById(R.id.goMain);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        ImageView listMember=(ImageView) findViewById(R.id.listmember);
        listMember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), memberListActivity.class);
                startActivity(intent);
            }
        });

    }
}
