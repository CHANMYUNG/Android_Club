package com.example.www.android_club.adpater;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.www.android_club.R;
import com.example.www.android_club.activities.*;

import com.example.www.android_club.recruit.RecyclerViewAdapter;

import java.util.ArrayList;

/**
 * Created by dsm2016 on 2017-08-21.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    Context context;

    public MainAdapter(Context context){
        this.context=context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.main_item_category,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        GridLayoutManager.LayoutParams params = (GridLayoutManager.LayoutParams)holder.main_category_card.getLayoutParams();
        switch (position){
            case 0:
                holder.main_category_title.setText("동아리 모집");
                holder.main_category_title.setTextColor(Color.parseColor("#ffffff"));
                holder.main_category_image.setImageResource(R.drawable.application);
                holder.main_category_layout.setBackgroundColor(Color.parseColor("#f4b06e"));
                params.setMargins(15, 15, 15, 15);
                holder.main_category_card.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(context,CircleCollectActivity.class);
                        context.startActivity(intent);
                    }
                });
                break;
            case 1:
                holder.main_category_title.setText("동아리 관리");
                holder.main_category_image.setImageResource(R.drawable.dmscircles);
                holder.main_category_title.setTextColor(Color.parseColor("#ffffff"));
                holder.main_category_card.setBackgroundColor(Color.parseColor("#f4b06e"));
                params.setMargins(15, 15, 15, 15);
                break;
        }

    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView main_category_title;
        ImageView main_category_image;
        CardView main_category_card;
        RelativeLayout main_category_layout;
        public ViewHolder(View v){
            super(v);
            this.main_category_card=(CardView)v.findViewById(R.id.main_category_card);
            this.main_category_title=(TextView)v.findViewById(R.id.main_category_title);
            this.main_category_image=(ImageView) v.findViewById(R.id.main_category_image);
            this.main_category_layout=(RelativeLayout)v.findViewById(R.id.main_category_layout);
        }

    }
}
