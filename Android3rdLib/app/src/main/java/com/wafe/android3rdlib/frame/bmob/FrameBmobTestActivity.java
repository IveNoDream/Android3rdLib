package com.wafe.android3rdlib.frame.bmob;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.wafe.android3rdlib.R;

/**
 * Created by root on 7/4/17.
 */

public class FrameBmobTestActivity extends AppCompatActivity implements View.OnClickListener{

    private Button mUpBtn = null;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //第一：默认初始化
        //Bmob.initialize(this, "2e10342f8b99bb0d08e3b64bc05220a4");

        setContentView(R.layout.frame_bmob_test_activity);
        mUpBtn = (Button) findViewById(R.id.bmob_btn_up);
        mUpBtn.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bmob_btn_up:

                break;
            default:
                break;
        }
    }
}
