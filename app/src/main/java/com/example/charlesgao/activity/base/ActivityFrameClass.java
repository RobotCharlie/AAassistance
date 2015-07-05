package com.example.charlesgao.activity.base;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.charlesgao.activity.R;

/**
 * Created by CharlesGao on 15-07-03.
 * Function: This is a class that is relevant to the Frame of the System, The Beginning of the the
 *           App.
 * Detail : It encapsulates the No-Title-Activity by calling a
 *           requestWindowFeature(Window.FEATURE_NO_TITLE);
 */
public class ActivityFrameClass extends ActivityBaseClass {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //The Activity that extending this class has no title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
    }

    //Calling MainBody dynamically
    protected void AppendMainBody(int ResID){
        LinearLayout MainBody = (LinearLayout)findViewById(R.id.layout_MainBody);
        View view = LayoutInflater.from(this).inflate(ResID, null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams
                (RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.MATCH_PARENT);
        MainBody.addView(view, layoutParams);
    }
}
