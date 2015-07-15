package com.example.charlesgao.activity.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.charlesgao.activity.Adapter.base.AdapterBaseClass;
import com.example.charlesgao.activity.Bussiness.BussinessUser;
import com.example.charlesgao.activity.Controls.SlideMenuItem;
import com.example.charlesgao.activity.R;

import java.util.List;

/**
 * Created by CharlesGao on 15-07-03.
 */
public class AdapterUser extends AdapterBaseClass {

    //Encapsulate Variables into this class for convenience
    private class Holder{
        TextView tvUserName;
        ImageView imageView;
    }

    public AdapterUser(Context context){
        super(context, null);
        BussinessUser bussinessUser = new BussinessUser(context);
        List list = bussinessUser.getNotHideUser();
        setmList(list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Holder holder;
        if(convertView == null){
            convertView = getmLayoutInflater().inflate(R.layout.slide_view_list_item, null);
            holder = new Holder();
            holder.tvMenuName = (TextView)convertView.findViewById(R.id.id_tv_menu_name);
            convertView.setTag(holder);
        }else {
            holder = (Holder)convertView.getTag();
        }

        SlideMenuItem slideMenuItem = (SlideMenuItem)getmList().get(position);
        holder.tvMenuName.setText(slideMenuItem.getmTitle());

        return convertView;
    }
}
