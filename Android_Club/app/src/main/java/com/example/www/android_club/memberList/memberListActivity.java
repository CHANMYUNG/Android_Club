package com.example.www.android_club.memberList;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.www.android_club.R;

import java.util.ArrayList;

/**
 * Created by 윤정현 on 2017-04-13.
 */

public class memberListActivity extends AppCompatActivity {
    ListView listView;
    ListAdapter listAdapter;
    ArrayList<list_item> list_itemsList;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.member_list);
        listView=(ListView)findViewById(R.id.listview1);
        list_itemsList=new ArrayList<list_item>();
        list_itemsList.add(new list_item("윤정현",R.drawable.ic_contacts_black_24dp));
        list_itemsList.add(new list_item("윤태훈",R.drawable.ic_contacts_black_24dp));
        list_itemsList.add(new list_item("윤1",R.drawable.ic_contacts_black_24dp));
        list_itemsList.add(new list_item("윤2",R.drawable.ic_contacts_black_24dp));
        list_itemsList.add(new list_item("윤3",R.drawable.ic_contacts_black_24dp));

        listAdapter=new ListAdapter(memberListActivity.this,list_itemsList);
        listView.setAdapter(listAdapter);
    }


}
