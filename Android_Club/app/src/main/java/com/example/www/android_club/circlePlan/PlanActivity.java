package com.example.www.android_club.circlePlan;


import com.example.www.android_club.R;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class PlanActivity extends AppCompatActivity {
    GridView gridView;
    List<Data> gridArray=new ArrayList<Data>();
    PlanAdapter gridAdapter;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_plan);

            //Resources resources = getResources();사진정보를 가져올때
            gridArray.add(new Data("1사람","인원모집","2017-1021"));
            gridArray.add(new Data("2사람","프로젝트준비","2017-1021"));
            gridArray.add(new Data("3사람","역활분담","2017-1021"));
            gridArray.add(new Data("4사람","공부","2017-1021"));
            //데이터베이스에서 들어온 데이터만큼 뿌려줄 예정

            gridView = (GridView) findViewById(R.id.gridview);
            gridAdapter = new PlanAdapter(this, R.layout.circleplan_rowitem, (ArrayList)gridArray);
            gridView.setAdapter(gridAdapter);


            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                    Toast.makeText(getApplicationContext(), gridArray.get(position).getText() + "  해당 index"+position, Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(PlanActivity.this, CirclePlanActivity.class);
                    String writer=gridArray.get(position).getText();
                    String title=gridArray.get(position).getTitle();
                    String content=gridArray.get(position).getDate();
                    intent.putExtra("writer",writer);
                    intent.putExtra("content",content);
                    intent.putExtra("title",title);

                    startActivity(intent);
                }
            });
        }
}

