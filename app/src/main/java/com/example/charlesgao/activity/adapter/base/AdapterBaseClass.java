package com.example.charlesgao.activity.Adapter.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by CharlesGao on 15-07-05.
 * Function: This is a Abstract Class that encapsulate some common method of Adapter class.
 */
public abstract class AdapterBaseClass extends BaseAdapter {

    private List mList;
    private Context mContext;
    private LayoutInflater mLayoutInflater;

    public AdapterBaseClass(Context context, List list){
        mContext = context;
        mList = list;
        mLayoutInflater = LayoutInflater.from(context);
    }

    public LayoutInflater getmLayoutInflater(){
        return mLayoutInflater;
    }

    public Context getmContext(){
        return mContext;
    }

    public List getmList(){
        return mList;
    }

    public void setmList(List list){
        mList = list;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

}
