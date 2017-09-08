package com.wafe.android3rdlib.custom.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by root on 9/8/17.
 */

public class CustomSurfaceViewSimpleActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String custom_class = getIntent().getStringExtra("custom_class");
        if ("sin".equals(custom_class)){
            setContentView(new CustomSinView(this));
        } else{
            setContentView(new CustomSimpleDraw(this));
        }

    }
}
