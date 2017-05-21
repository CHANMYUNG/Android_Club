package com.example.www.android_club.clubList;

import android.graphics.drawable.Drawable;

/**
 * Created by 윤정현 on 2017-05-21.
 */

public class Club {

    int image;
    String clubName;
    String reader;
    int memberNum;


    public Club(int image, String clubName, String reader, int memberNum) {
        this.image = image;
        this.clubName = clubName;
        this.reader = reader;
        this.memberNum = memberNum;
    }



    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getReader() {
        return reader;
    }

    public void setReader(String reader) {
        this.reader = reader;
    }

    public int getMemberNum() {
        return memberNum;
    }

    public void setMemberNum(int memberNum) {
        this.memberNum = memberNum;
    }





}