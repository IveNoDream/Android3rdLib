package com.wafe.android3rdlib.custom.customseekbar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.SeekBar;

import com.wafe.android3rdlib.R;
import com.wafe.android3rdlib.util.LogUtils;

/**
 * Created by wafej on 2018/4/19.
 */

public class CustomSeekBarActivity extends AppCompatActivity {
    private  CustomSeekbarView mCSBV = null;
    private VerticalSeekBar mVSB = null;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_seekbar_activity);
        mCSBV = (CustomSeekbarView) findViewById(R.id.csbv_vertical);
        mVSB = (VerticalSeekBar) findViewById(R.id.vsb_vertical);
        int length = mVSB.getMax();
        mCSBV.setLength(length);
        mCSBV.setwidth(20);
        mVSB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                LogUtils.i(LogUtils.TAG,"curProcess： " + i);
                mCSBV.update(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
