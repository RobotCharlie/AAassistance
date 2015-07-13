package com.example.charlesgao.activity.Model;

import java.util.Date;

/**
 * Created by CharlesGao on 15-07-11.
 */
public class ModelUser {

    //Primary Key of the Table
    private int userId;
    private String userName;
    private Date createDate = new Date();
    private int state = 1;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }




}
