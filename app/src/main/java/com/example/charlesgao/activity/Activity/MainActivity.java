package com.example.charlesgao.activity.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.Toast;

import com.example.charlesgao.activity.R;
import com.example.charlesgao.activity.Adapter.AdapterAppGrid;
import com.example.charlesgao.activity.Activity.base.ActivityFrameClass;
import com.example.charlesgao.activity.Controls.SlideMenuItem;
import com.example.charlesgao.activity.Controls.SlideMenuView;


public class MainActivity extends ActivityFrameClass implements SlideMenuView.OnSlideMenuListener{

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
        CreateSlideMenu(R.array.SlideMenuActivityMain);

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


    /**This is a "CallBack" method that waiting for the "Event"
     * Here, the MainActivity Class define the following method(define the task or behaviour),
     * this is called CallBack. The "Event" is the method without definition,
     * which is in {@link com.example.charlesgao.activity.Controls.SlideMenuView.OnSlideMenuItemClick}
     * The following "CallBack" method is here waiting to be called.
     * For detailed explanation visit: http://stackoverflow.com/questions/9596276/how-to-explain-callbacks-in-plain-english-how-are-they-different-from-calling-o/9652434#9652434
     */
    @Override
    public void onSlideMenuItemClick(View view, SlideMenuItem slideMenuItem) {
        Toast.makeText(this, slideMenuItem.getmTitle(),Toast.LENGTH_LONG).show();
    }
}
