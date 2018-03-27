package com.wafe.android3rdlib.custom.moveview;

import android.app.Application;
import android.view.WindowManager;

/**
 * Created by wafej on 2018/3/27.
 */

public class WMApplication extends Application {
    private WindowManager.LayoutParams wmParams=new WindowManager.LayoutParams();

    public WindowManager.LayoutParams getWMParams(){
        return wmParams;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
