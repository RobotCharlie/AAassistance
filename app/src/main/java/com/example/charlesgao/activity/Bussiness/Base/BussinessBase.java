package com.example.charlesgao.activity.Bussiness.Base;

import android.content.Context;

import java.util.Objects;

/**
 * Created by CharlesGao on 15-07-12.
 */
public class BussinessBase {

    private Context context;

    protected BussinessBase(Context context){
        this.context = context;
    }

    protected String getString(int resId){
        return context.getString(resId);
    }

    protected String getString(int resId, Objects[] objectses){
        return context.getString(resId, objectses);
    }



}
