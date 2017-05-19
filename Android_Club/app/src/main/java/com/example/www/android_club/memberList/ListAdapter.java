package com.example.www.android_club.memberList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.www.android_club.R;

import java.util.ArrayList;

/**
 * Created by 윤정현 on 2017-04-13.
 */

public class ListAdapter extends BaseAdapter{
    Context context;
    ArrayList<list_item> list_items;
    TextView textView;
    ImageView imageView;

    public ListAdapter(Context context,ArrayList<list_item>list_items) {
        this.context = context;
        this.list_items=list_items;
    }

    @Override
    public int getCount() {
        return this.list_items.size();
    }

    @Override
    public Object getItem(int position) {
        return this.list_items.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        if(convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.member_list_item,null);
            textView = (TextView)convertView.findViewById(R.id.text1);
            imageView=(ImageView)convertView.findViewById(R.id.iamge1);

            textView.setText(list_items.get(position).getName());
            imageView.setImageResource(list_items.get(position).getImage());


        }
        return convertView;
    }

}
class list_item {

    private String name;
    private int image;

    public list_item(String name,int image){
        this.name=name;
        this.image=image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }


}
