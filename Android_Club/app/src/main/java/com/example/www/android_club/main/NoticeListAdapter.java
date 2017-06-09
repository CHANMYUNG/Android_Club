package com.example.www.android_club.main;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.www.android_club.R;
import java.util.List;

/**
 * Created by 윤정현 on 2017-05-20.
 */

public class NoticeListAdapter extends BaseAdapter {
    private Context context;
    private List<Notice> noticeList;

    public NoticeListAdapter(Context context, List<Notice> noticeList) {
        this.context = context;
        this.noticeList = noticeList;
    }

    @Override
    public int getCount() {
        return noticeList.size();
    }

    @Override
    public Object getItem(int i) {
        return noticeList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v=View.inflate(context, R.layout.noticeitem,null);
        TextView noticeText=(TextView) v.findViewById(R.id.noticeText);
        TextView nameText=(TextView) v.findViewById(R.id.nameText);
        TextView dateText=(TextView) v.findViewById(R.id.dateText);

        noticeText.setText(noticeList.get(i).getNotice());
        nameText.setText(noticeList.get(i).getName());
        dateText.setText(noticeList.get(i).getDate());

        v.setTag(noticeList.get(i).getNotice());

        return  v;

    }
}
