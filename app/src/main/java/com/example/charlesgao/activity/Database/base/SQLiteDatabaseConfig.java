package com.example.charlesgao.activity.Database.base;

import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * Created by CharlesGao on 15-07-06.
 * Function: Configuration file of Database that using Singleton design pattern to make sure just have one
 *           config file in this app.
 */
public class SQLiteDatabaseConfig {

    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "AADatabase";
    private static SQLiteDatabaseConfig INSTANCE;

    private SQLiteDatabaseConfig(){

    }

    //Singleton
    public static SQLiteDatabaseConfig getInstance(){
        if(INSTANCE == null){
            INSTANCE = new SQLiteDatabaseConfig();
        }
        return INSTANCE;
    }

    public String getBatabaseName(){
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
