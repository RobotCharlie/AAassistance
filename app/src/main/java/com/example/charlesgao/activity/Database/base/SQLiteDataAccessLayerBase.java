package com.example.charlesgao.activity.Database.base;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by CharlesGao on 15-07-11.
 * Android offer you a class called SQLiteDatabase, this class encapsulate some API of manipulation
 * of Database. e.g.: getWritableDatabase() and gerReadableDatabase();
 */
public abstract class SQLiteDataAccessLayerBase {

    private Context context;
    private SQLiteDatabase sqLiteDatabase;

    public SQLiteDataAccessLayerBase (Context context){
        this.context = context;
    }

    protected Context getContext(){
        return this.context;
    }

    public SQLiteDatabase getSqLiteDatabase(){
        if (sqLiteDatabase == null){
            sqLiteDatabase = SQLiteHelper.getInstance(context).getWritableDatabase();
        }
        return sqLiteDatabase;
    }

    public void beginTransaction(){
        sqLiteDatabase.beginTransaction();
    }
    public void setTransaction(){
        sqLiteDatabase.setTransactionSuccessful();
    }
    public void endTransacion(){
        sqLiteDatabase.endTransaction();
    }

    public int getCount(String condition){
        String[] strings = getTableNameAndPrimaryKey();
        Cursor cursor = execSql("SELECT "+ strings[1] + " FROM " + strings[0] + "WHERE 1=1" + condition);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }

    //Get the number of the rows
    public int getCount(String primaryKey, String tableName, String condition){
        Cursor cursor = execSql("SELECT " + primaryKey + " FROM " + tableName + "WHERE 1=1" + condition);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }

    protected Boolean delete(String tableName, String condition){
        return getSqLiteDatabase().delete(tableName, " 1=1" + condition, null) >0 ;
    }

    protected abstract String[] getTableNameAndPrimaryKey();

    //Transfer a cursor to a entity
    protected abstract Object findModel(Cursor cursor);

    protected List cursorToList(Cursor cursor){
        List list = new ArrayList();
        while(cursor.moveToNext()){
            Object object = findModel(cursor);
            list.add(object);
        }
        return list;
    }

    public Cursor execSql (String sqlText){
        return getSqLiteDatabase().rawQuery(sqlText, null);
    }


}
