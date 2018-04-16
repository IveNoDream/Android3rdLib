package com.wafe.android3rdlib.util;

import android.util.Log;

/**
 * Created by root on 2/6/17.
 */
public class LogUtils {
    public final static String TAG = "ssss";
    public static void i(String tag, String msg) {
        Log.i(TAG + tag,msg);
    }

    public static void e(String tag, String msg) {
        Log.e(TAG + tag,msg);
    }
}
