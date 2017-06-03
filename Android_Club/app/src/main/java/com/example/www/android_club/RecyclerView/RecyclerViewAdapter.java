package com.example.www.android_club.RecyclerView;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.www.android_club.R;

import java.util.ArrayList;

/**
 * Created by 윤정현 on 2017-06-04.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    Context context;
    ArrayList<CircleData> items=new ArrayList<>();
    int item_layout;


    public RecyclerViewAdapter(Context context,ArrayList<CircleData> items,int item_layout){
        this.context=context;
        this.items=items;
        this.item_layout=item_layout;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.recruit_recyclertview_item,null);
        return new ViewHolder(v); //각각의 아이템들을 세팅해줌
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final CircleData item=items.get(position);
        Drawable drawable=ContextCompat.getDrawable(context,item.getImg());
        holder.image.setBackground(drawable);
        holder.circleText.setText(item.getCircleText());
        holder.circleContext.setText(item.getCircleContext());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Toast.makeText(context,item.getCircleText(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView circleText;
        TextView circleContext;
        CardView cardView;

        public ViewHolder(View view){
            super(view);
            image=(ImageView) itemView.findViewById(R.id.img);
            cardView=(CardView) itemView.findViewById(R.id.cardView);
            circleText=(TextView) itemView.findViewById(R.id.circleNameTextView);
            circleContext=(TextView) itemView.findViewById(R.id.circleContentTextView);
        }
    }
}
class CircleData{
    String CircleText;
    String CircleContext;
    int img;

    public String getCircleText() {
        return CircleText;
    }

    public void setCircleText(String circleText) {
        CircleText = circleText;
    }

    public String getCircleContext() {
        return CircleContext;
    }

    public void setCircleContext(String circleContext) {
        CircleContext = circleContext;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }


    public CircleData(String circleText,String circleContext,int img){
        this.CircleContext=circleContext;
        this.CircleText=circleText;
        this.img=img;
    }
}