package com.example.www.android_club.circlePlan;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.www.android_club.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by 윤정현 on 2017-04-05.
 */

public class  PlanAdapter extends ArrayAdapter<Data> {
    private ArrayList<Data> items=new ArrayList<>();
    private List<Data> arrayList=null;
    Context context;
    int layout;

    public PlanAdapter(Context context, int layout, ArrayList<Data> items){
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

            Data m=items.get(position);

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


}
class Data{
    private String text;
    private String date;
    private String title;

    public Data(String text , String title, String  date) {
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
