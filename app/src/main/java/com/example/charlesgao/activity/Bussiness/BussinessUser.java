package com.example.charlesgao.activity.Bussiness;

import android.content.Context;

import com.example.charlesgao.activity.Bussiness.Base.BussinessBase;
import com.example.charlesgao.activity.Database.SQLiteDataAccessLayer.SQLiteDALUser;
import com.example.charlesgao.activity.Model.ModelUser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CharlesGao on 15-07-12.
 */
public class BussinessUser extends BussinessBase{

    private SQLiteDALUser sqLiteDALUser;

    public BussinessUser(Context context) {
        super(context);
        sqLiteDALUser = new SQLiteDALUser(context);
    }

    public List<ModelUser> getNotHideUser(){
        return sqLiteDALUser.getUser(" AND State = 1");
    }





//--------------------------------------------------------------------------------------------------
//-------------------------------------------ADD,DELETE,UPDATE,RETRIEVE-----------------------------
//--------------------------------------------------------------------------------------------------

    //Return a result that can tell you wether or not the User has been successfully inserted
    public boolean insertUser(ModelUser modelUser){
        boolean result = sqLiteDALUser.insertUser(modelUser);
        return result;
    }

    public boolean deleteUserByUserId(int userId){
        String condition = " AND userId = " + userId;
        boolean result = sqLiteDALUser.deleteUser(condition);
        return result;
    }

    public boolean updateUserByUserId(ModelUser modelUser){
        String condition = " AND userId = " + modelUser.getUserId();
        boolean result = sqLiteDALUser.updateUser(condition, modelUser);
        return result;
    }

    //Retrieve list of users by Condition
    private List<ModelUser> getUser(String condition){
        return sqLiteDALUser.getUser(condition);
    }

    //Retrieve one user by userId
    public ModelUser getModelUserByUserId(int userId){
        List<ModelUser> list = sqLiteDALUser.getUser(" AND userId = " + userId);
        if (list.size() == 1) {
            return list.get(0);
        }
        else {
            return null;
        }
    }

    //Retrieve list of users by userId
    public List<ModelUser> getUserListByUserId(String userId[]){
        List<ModelUser> list = new ArrayList<>();
        for (int i = 0; i < userId.length; i++) {
            list.add(getModelUserByUserId(Integer.valueOf(userId[i])));
        }
        return list;
    }

//--------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------




}
