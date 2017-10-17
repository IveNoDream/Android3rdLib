package com.wafe.android3rdlib.other.syserror;

import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.wafe.android3rdlib.R;
import com.wafe.android3rdlib.util.LogUtils;

import java.io.File;

/**
 * Created by root on 10/17/17.
 */

public class OtherOOMTestActivity extends AppCompatActivity {
    private static final String TAG = "OtherOOMTest";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.other_syserror_oom_test_activity);

        final String HPROFILE_PATH = Environment.getExternalStorageDirectory() + "/storage/emulated/0/hhhhh/dddd";
        File dir = new File(HPROFILE_PATH);
        if (!dir.exists()){
            LogUtils.i(TAG, " not exists make it: " + dir.mkdirs());
            //dir.mkdirs();
        }
        LogUtils.i(TAG, " Path: " + HPROFILE_PATH);
        if (dir.exists()){
            LogUtils.i(TAG, " OK----------");
        }
        new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    LogUtils.i(TAG,"*************************");
                    java.util.List list = new java.util.ArrayList();
                    double[] tmp = new double[999999999];
                    list.add(tmp);
                }
            }
        }).start();
    }
}
