package com.example.charlesgao.activity.Activity;

import android.os.Bundle;
import android.widget.GridView;

import com.example.charlesgao.activity.R;
import com.example.charlesgao.activity.adapter.AdapterAppGrid;
import com.example.charlesgao.activity.Activity.base.ActivityFrameClass;


public class MainActivity extends ActivityFrameClass {

    private GridView mGridview;
    private AdapterAppGrid mAdapterAppGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppendMainBody(R.layout.main_body);
//        setContentView(R.layout.activity_main);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);

        initVariable();
        initListener();
        initView();
        bindData();
        CreatSlideMenu(R.array.SlideMenuActivityMain);

    }

    public void initVariable(){
        mAdapterAppGrid = new AdapterAppGrid(this);
    }

    public void initView(){
        mGridview = (GridView)findViewById(R.id.id_main_body_grid_view);
    }

    public void initListener(){

    }

    public void bindData(){
        mGridview.setAdapter(mAdapterAppGrid);
    }
}
