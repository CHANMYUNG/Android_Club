package com.example.www.android_club;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

/**
 * Created by 윤정현 on 2017-04-05.
 */

public class  MainAdapter extends ArrayAdapter<MainData> {
    private ArrayList<MainData> items=new ArrayList<>();
    private List<MainData> arrayList=null;
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
        View row = convertView;
        ReordHoder holder = null;

        if(row==null){
            LayoutInflater inflater=((Activity)context).getLayoutInflater();
            row=inflater.inflate(layout,parent,false);

            holder=new ReordHoder();
            holder.textView=(TextView)row.findViewById(R.id.clubtext);
            holder.imageView=(ImageView)row.findViewById(R.id.clubimage);
            BitmapDrawable bd = null;

            MainData m=items.get(position);

            bd = (BitmapDrawable) items.get(position).getImg().getCurrent();
            Bitmap bmp= bd.getBitmap();
            holder.imageView.setImageBitmap(bmp);
            holder.textView.setText(m.getText());


        }else{
            holder=(ReordHoder)row.getTag();
        }
        return  row;
    }
    static class ReordHoder{
        TextView textView;
        ImageView imageView;
    }

    public void filter(String charText){
        charText=charText.toLowerCase(Locale.getDefault());
        items.clear();
        if(charText.length()==0){
            items.addAll(arrayList);
        }else{
            for(MainData ma :arrayList){
                if(ma.getText().contains(charText)){
                    items.add(ma);
                }
            }
        }
        notifyDataSetChanged();
    }

}
class MainData{
    private String text;
    private Drawable img;

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

    public String getText() {
        return text;
    }

    public Drawable getImg() {
        return img;
    }
}
