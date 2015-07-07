package com.example.charlesgao.activity.controls;

/**
 * Created by CharlesGao on 15-07-05.
 * Function: Encapsulate the items that in SlideMenu
 */
public class SlideMenuItem {


    private int mItemID;
    private String mTitle;

    public SlideMenuItem(int i, String string){
        mItemID = i;
        mTitle = string;
    }

    public int getmItemID() {
        return mItemID;
    }

    public void setmItemID(int mItemID) {
        this.mItemID = mItemID;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }



}
