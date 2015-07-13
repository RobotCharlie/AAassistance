package com.example.charlesgao.activity.Database.SQLiteDataAccessLayer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.charlesgao.activity.Database.Base.SQLiteDALBase;
import com.example.charlesgao.activity.R;
import com.example.charlesgao.activity.Utility.DateTools;

import com.example.charlesgao.activity.Model.ModelUser;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * Created by CharlesGao on 15-07-12.
 * Function: This class is a Abstract Layer(called DataAccessLayer) that can offer you the methods
 *           that manipulate the data by add, remove, modify, retrieve.
 *           This Layer also extends the {@link com.example.charlesgao.activity.Database.Base.SQLiteDALBase}, which implements the
 *           Interface {@link com.example.charlesgao.activity.Database.Base.SQLiteHelper.SQLiteDataTable}
 *           in {@link com.example.charlesgao.activity.Database.Base.SQLiteHelper}
 *           Two Main Functions:
 *                  1. add, remove, modify, retrieve;
 *                  2. create Table
 */
public class SQLiteDALUser extends SQLiteDALBase {

    public SQLiteDALUser(Context context) {
        super(context);
    }
//--------------------------------------------------------------------------------------------------
//-------------------------------------------ADD,DELETE,UPDATE,RETRIEVE-----------------------------
//--------------------------------------------------------------------------------------------------


    //ADD
    public boolean insertUser(ModelUser modelUser){
        ContentValues contentValues = createParams(modelUser);
        long newId = getSqLiteDatabase().insert(getTableNameAndPrimaryKey()[0], null, contentValues);
        modelUser.setUserId((int) newId);

        return newId > 0;
    }

    //DELETE
    public boolean deleteUser(String condition) {
        return delete(getTableNameAndPrimaryKey()[0], condition);
    }

    //UPDATE
    public boolean updateUser(String condition, ModelUser modelUser){
        ContentValues contentValues = createParams(modelUser);
        return getSqLiteDatabase().update(getTableNameAndPrimaryKey()[0],contentValues,condition,null)>0;
    }

    //RETRIEVE
    public List<ModelUser> getUser(String condition){
        String sqlText = "SELECT * FROM Users WHERE 1 = 1 "+condition;
        return getList(sqlText);
    }

//--------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------



    @Override
    protected String[] getTableNameAndPrimaryKey() {
        return new String[]{"User", "userId"};
    }

    @Override
    protected Object findModel(Cursor cursor) {
        ModelUser modelUser = new ModelUser();
        modelUser.setUserId(cursor.getInt(cursor.getColumnIndex("userId")));
        modelUser.setUserName(cursor.getString(cursor.getColumnIndex("userName")));
        try {
            Date createDate = DateTools.stringToDate(cursor.getString(cursor.getColumnIndex("createDate")));
            modelUser.setCreateDate(createDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        modelUser.setState(cursor.getInt(cursor.getColumnIndex("state")));
        return modelUser;
    }

    private void initDefaultData(SQLiteDatabase sqLiteDatabase){
        ModelUser modelUser = new ModelUser();
        String userName[] = getContext().getResources().getStringArray(R.array.InitDefaultUserName);
        for (int i = 0; i <userName.length ; i++) {
            modelUser.setUserName(userName[i]);
            ContentValues contentValues = createParams(modelUser);
            sqLiteDatabase.insert(getTableNameAndPrimaryKey()[0],null,contentValues);
        }
    }


    @Override
    public void OnCreate(SQLiteDatabase database) {
        database.execSQL("CREATE TABLE User (\n" +
                "    userId     INTEGER      PRIMARY KEY AUTOINCREMENT\n" +
                "                            NOT NULL,\n" +
                "    userName   VARCHAR (10) NOT NULL,\n" +
                "    createDate DATETIME     NOT NULL,\n" +
                "    state      INTEGER      NOT NULL\n" +
                ");\n");

        //Add some default data in DB
        initDefaultData(database);
    }

    @Override
    public void OnUpgrade(SQLiteDatabase database) {

    }

    public ContentValues createParams(ModelUser modelUser){
        ContentValues contentValues = new ContentValues();
        contentValues.put("UserName", modelUser.getUserName());
        contentValues.put("Create Date", DateTools.dateToString
                (modelUser.getCreateDate(), DateTools.Resolution.MINUTE));
        contentValues.put("State", modelUser.getState());
        return contentValues;
    }



}
