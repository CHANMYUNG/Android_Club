package com.example.www.android_club;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by 윤정현 on 2017-04-05.
 */

public class  MainAdapter extends ArrayAdapter<MainData> {
    private ArrayList<MainData> items=new ArrayList<>();
    Context context;
    int layout;

    public MainAdapter(Context context,int layout,ArrayList<MainData> items){
        super(context, layout, items);
        this.context=context;
        this.layout=layout;
        this.items=items;
    }

    public int getCount(){
        return  items.size();
    }

    public long getItemId(int position){
        return  position;
    }

    /*public Object getItem(int position){
        return items.get(position);
    }*/

    public View getView(int position, View convertView, ViewGroup parent){
        View row=convertView;
        ReordHoder holder=null;
        if(row==null){
            LayoutInflater inflater=((Activity)context).getLayoutInflater();
            row=inflater.inflate(layout,parent,false);

            holder=new ReordHoder();
            holder.textView=(TextView)row.findViewById(R.id.clubtext);
            holder.imageView=(ImageView)row.findViewById(R.id.clubimage);
        }else{
            holder=(ReordHoder)row.getTag();
        }
        return  row;
    }
    static class ReordHoder{
        TextView textView;
        ImageView imageView;
    }

}
class MainData{
    public String text;
    public Drawable img;
    public MainData(String text , Drawable img) {
        this.img = img;
        this.text = text;
    }

    public void setText(String text){
        this.text=text;
    }

    public void setImg(Drawable img){
        this.img=img;
    }

}
