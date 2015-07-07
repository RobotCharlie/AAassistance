package com.example.charlesgao.activity.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.charlesgao.activity.R;
import com.example.charlesgao.activity.Adapter.base.AdapterBaseClass;
import com.example.charlesgao.activity.Controls.SlideMenuItem;

import java.util.List;

/**
 * Created by CharlesGao on 15-07-03.
 */
public class AdapterSlideMenu extends AdapterBaseClass {

    //Encapsulate Variables into this class for convenience
    private class Holder{
        TextView tvMenuName;
    }

    public AdapterSlideMenu(Context context, List list){
        super(context,list);
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
