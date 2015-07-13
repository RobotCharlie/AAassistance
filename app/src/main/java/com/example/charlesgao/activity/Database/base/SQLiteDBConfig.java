package com.example.charlesgao.activity.Database.Base;

import java.util.ArrayList;

/**
 * Created by CharlesGao on 15-07-06.
 * Function: Configuration file of Database that using Singleton design pattern to make sure just have one
 *           config file in this app.
 */
public class SQLiteDBConfig {

    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "AADatabase";
    private static SQLiteDBConfig INSTANCE;

    private SQLiteDBConfig(){

    }

    //Singleton
    public static SQLiteDBConfig getInstance(){
        if(INSTANCE == null){
            INSTANCE = new SQLiteDBConfig();
        }
        return INSTANCE;
    }

    public String getDatabaseName(){
        return DATABASE_NAME;
    }

    public int getVersion(){
        return VERSION;
    }

    public ArrayList<String> getTables(){
        ArrayList<String> arrayList = new ArrayList<>();
        return arrayList;
    }

}
