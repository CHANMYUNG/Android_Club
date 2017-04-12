package android_loading;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.example.www.android_club.MainActivity;
import com.example.www.android_club.R;

/**
 * Created by 윤정현 on 2017-04-03.
 */

public class loadingActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        Handler handler=new Handler();
        handler.postDelayed(new splashhandler(),2000);

    }

    private class splashhandler implements Runnable{
        public void run(){
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }
    }


}
