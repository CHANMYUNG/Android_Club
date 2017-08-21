package com.example.www.android_club.adpater;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.www.android_club.R;
import com.example.www.android_club.recruit.RecyclerViewAdapter;

import java.util.ArrayList;

/**
 * Created by dsm2016 on 2017-08-21.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    ArrayList<String> arrayList;
    Context context;

    public MainAdapter(Context context,ArrayList<String> arrayList){
        this.context=context;
        this.arrayList=arrayList;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.main_item_category,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.categoryTitleView.setText(arrayList.get(position));

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView categoryTitleView;

        public ViewHolder(View v){
            super(v);
            categoryTitleView=(TextView)v.findViewById(R.id.main_category_title);
        }

    }
}
