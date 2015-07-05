package com.example.charlesgao.activity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.charlesgao.activity.R;

/**
 * Created by CharlesGao on 15-07-03.
 */
public class AdapterAppGrid extends BaseAdapter {

    //Encapsulate Variables into this class for convenience
    private class Holder{
        ImageView imageView;
        TextView textView;
    }

    private Context mContext;

    private Integer[] mImageInteger ={
            R.drawable.app_grid_view_add_payment,
            R.drawable.app_grid_view_check_payment,
            R.drawable.app_grid_view_statistic,
            R.drawable.app_grid_view_book_management,
            R.drawable.app_grid_view_category_management,
            R.drawable.app_grid_view_user_management
    };

    private String[] mImageString = new String[6];

    public AdapterAppGrid(Context context){

        mContext = context;
        mImageString[0] = context.getString(R.string.app_grid_view_add_payment);
        mImageString[1] = context.getString(R.string.app_grid_view_check_payment);
        mImageString[2] = context.getString(R.string.app_grid_view_statistic);
        mImageString[3] = context.getString(R.string.app_grid_view_book_management);
        mImageString[4] = context.getString(R.string.app_grid_view_category_management);
        mImageString[5] = context.getString(R.string.app_grid_view_user_management);

    }

    @Override
    public int getCount() {
        return mImageString.length;
    }

    @Override
    public Object getItem(int position) {
        return mImageString[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Holder holder;
        if(convertView == null){
            LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            convertView = layoutInflater.inflate(R.layout.main_body_item,null);
            holder = new Holder();
            holder.imageView = (ImageView)convertView.findViewById(R.id.id_iv_icon);
            holder.textView = (TextView)convertView.findViewById(R.id.id_tv_name);
            convertView.setTag(holder);
        }else {
            holder = (Holder)convertView.getTag();
        }
        holder.imageView.setImageResource(mImageInteger[position]);
        holder.textView.setText(mImageString[position]);
        return convertView;
    }
}
