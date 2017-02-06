package com.wafe.android3rdlib;

import android.util.Log;

/**
 * Created by root on 2/6/17.
 */
public class LogUtils {
    public static void i(String tag, String msg) {
        Log.i(tag,msg);
    }

    public static void e(String tag, String msg) {
        Log.e(tag,msg);
    }
}
