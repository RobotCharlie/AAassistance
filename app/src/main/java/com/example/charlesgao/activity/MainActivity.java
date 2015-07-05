package com.example.charlesgao.activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.GridView;

import com.example.charlesgao.activity.adapter.AdapterAppGrid;
import com.example.charlesgao.activity.base.ActivityFrameClass;


public class MainActivity extends ActivityFrameClass {

    private GridView mGridview;
    private AdapterAppGrid mAdapterAppGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppendMainBody(R.layout.main_body);
//        setContentView(R.layout.activity_main);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);

        InitVariable();
        InitListener();
        InitView();
        BindData();

    }

    public void InitVariable(){
        mAdapterAppGrid = new AdapterAppGrid(this);
    }

    public void InitView(){
        mGridview = (GridView)findViewById(R.id.id_main_body_grid_view);
    }

    public void InitListener(){

    }

    public void BindData(){
        mGridview.setAdapter(mAdapterAppGrid);
    }
}
