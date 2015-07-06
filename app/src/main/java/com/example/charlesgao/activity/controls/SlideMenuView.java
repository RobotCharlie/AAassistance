package com.example.charlesgao.activity.controls;

import android.app.Activity;
import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.example.charlesgao.activity.R;
import com.example.charlesgao.activity.adapter.AdapterSlideMenu;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by CharlesGao on 15-07-05.
 */
public class SlideMenuView {

    private Activity mActivity;
    private List mMenuList;
    private boolean mIsClosed;
    private RelativeLayout mLayBottomBox;

    public SlideMenuView(Activity pActivity) {
        mActivity = pActivity;
        initVariable();
        initView();
        initListener();

    }

    public void initVariable() {
        mMenuList = new ArrayList();
        mIsClosed = true;
    }

    public void initView() {
        mLayBottomBox = (RelativeLayout) mActivity.findViewById(R.id.id_include_bottom_box);
    }

    public void initListener() {
        mLayBottomBox.setOnClickListener(new OnSlideMenuClick());
    }

    private void open() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams
                (RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        layoutParams.addRule(RelativeLayout.BELOW, R.id.id_include_title);
        mLayBottomBox.setLayoutParams(layoutParams);
        mIsClosed = false;

    }

    private void close() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams
                (RelativeLayout.LayoutParams.MATCH_PARENT, 60);
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        mLayBottomBox.setLayoutParams(layoutParams);
        mIsClosed = true;

    }

    private void toggle() {
        if (mIsClosed == true) {
            open();
        } else {
            close();
        }

    }

    public void add(SliderMenuItem pSliderMenuItem) {
        mMenuList.add(pSliderMenuItem);
    }

    public void bindList() {
        //2.Setup and Initialize the adapter
        AdapterSlideMenu adapterSlideMenu = new AdapterSlideMenu(mActivity, mMenuList);
        ListView listView = (ListView)mActivity.findViewById(R.id.id_list_view_slide_list);
        //3.Connection
        listView.setAdapter(adapterSlideMenu);

        //Add ListView Event Listener
        listView.setOnItemClickListener(new OnSlideMenuItemClick());
    }

    private void onSlideMenuClick() {

    }

    private class OnSlideMenuClick implements View.OnClickListener {

        @Override
        public void onClick(View v) {

        }
    }


    private class OnSlideMenuItemClick implements AdapterView.OnItemClickListener{

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        }
    }


}
