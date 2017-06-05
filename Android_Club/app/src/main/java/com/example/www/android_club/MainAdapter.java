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
        Content holder = null;

        if(row==null){
            LayoutInflater inflater=((Activity)context).getLayoutInflater();
            row=inflater.inflate(layout,parent,false);

            holder=new Content();
            holder.textView1=(TextView)row.findViewById(R.id.writerPlan);
            holder.textView2=(TextView)row.findViewById(R.id.titlePlan) ;
            holder.textView3=(TextView)row.findViewById(R.id.planDate) ;
            BitmapDrawable bd = null;

            MainData m=items.get(position);

        /*    bd = (BitmapDrawable) items.get(position).getImg().getCurrent();
            Bitmap bmp= bd.getBitmap();
            holder.imageView.setImageBitmap(bmp);*/
            //이미지를 넣는 방식
            holder.textView1.setText(m.getText());
            holder.textView2.setText(m.getTitle());
            holder.textView3.setText(m.getDate());


        }else{
            holder=(Content) row.getTag();
        }
        return  row;
    }
    static class Content{
        TextView textView1;
        TextView textView2;
        TextView textView3;
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
    private String date;
    private String title;

    public MainData(String text , String title, String  date) {
        this.date=date;
        this.text = text;
        this.title=title;
    }

    public void setText(String text){
        this.text=text;
    }

    public void setDate(String date){
        this.date=date;
    }

    public String getText() {
        return text;
    }

    public String getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
