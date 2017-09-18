package com.example.www.android_club.model;

/**
 * Created by 윤정현 on 2017-09-11.
 */

public class Circle {

    private String part;
    private String intro;

    private int totalMember;
    private int RecruitMember;

    public Circle(String part, String intro, int totalMember, int recruitMember) {
        this.part = part;
        this.intro = intro;
        this.totalMember = totalMember;
        RecruitMember = recruitMember;
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public int getTotalMember() {
        return totalMember;
    }

    public void setTotalMember(int totalMember) {
        this.totalMember = totalMember;
    }

    public int getRecruitMember() {
        return RecruitMember;
    }

    public void setRecruitMember(int recruitMember) {
        RecruitMember = recruitMember;
    }



}
