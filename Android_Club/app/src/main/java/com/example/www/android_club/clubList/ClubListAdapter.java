package com.example.www.android_club.clubList;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.www.android_club.Notice;
import com.example.www.android_club.R;

import java.util.List;

/**
 * Created by 윤정현 on 2017-05-21.
 */

public class ClubListAdapter extends BaseAdapter {
    private Context context;
    private List<Club> clubList;

    public ClubListAdapter(Context context, List<Club> clubList) {
        this.context = context;
        this.clubList = clubList;
    }



    @Override
    public int getCount() {
        return clubList.size();
    }

    @Override
    public Object getItem(int i) {
        return clubList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v=View.inflate(context, R.layout.club,null);
        ImageView clubIcon=(ImageView)v.findViewById(R.id.clubImage);
        TextView clubNameText=(TextView) v.findViewById(R.id.clubName);
        TextView clubReader=(TextView) v.findViewById(R.id.clubReader);
        TextView clubMemberNum=(TextView) v.findViewById(R.id.clubMemberNum);

        clubIcon.setImageResource(clubList.get(i).getImage());
        clubNameText.setText(clubList.get(i).getClubName());
        clubReader.setText(clubList.get(i).getReader());
        clubMemberNum.setText(String.valueOf(clubList.get(i).getMemberNum()));//int 값을 넘겨주면 id값하고 헷갈리기 때문에 String 형식으로 넘겨줘야함


        v.setTag(clubList.get(i).getClubName());
        return  v;


    }
}
