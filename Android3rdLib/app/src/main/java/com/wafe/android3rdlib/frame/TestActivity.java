package com.wafe.android3rdlib.frame;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.ViewGroup;

import com.wafe.android3rdlib.R;

/**
 * Created by root on 7/4/17.
 */

public class TestActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ViewGroup content = (ViewGroup) findViewById(android.R.id.content);

    }



}
