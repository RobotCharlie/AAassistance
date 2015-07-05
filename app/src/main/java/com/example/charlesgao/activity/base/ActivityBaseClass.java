package com.example.charlesgao.activity.base;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;


/**
 *Created by CharlesGao on 15-07-01.
 * Function: This is the Class that encapsulate Non-business-Logic-related methods, in order to
 *           make convenience to the regular methods-call like
 *           {@link android.widget.Toast};
 *           {@link android.content.Intent};
 *           {@link android.app.AlertDialog}
 */
public class ActivityBaseClass extends Activity {

    protected void ShowMsg(String string){
        Toast.makeText(this, string, Toast.LENGTH_LONG).show();
    }

    protected void OpenActivity(Class<?> newClass){
        Intent intent = new Intent();
        intent.setClass(this, newClass);
        startActivity(intent);
    }


}
