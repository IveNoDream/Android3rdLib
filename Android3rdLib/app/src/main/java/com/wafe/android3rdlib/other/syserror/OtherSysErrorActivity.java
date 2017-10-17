package com.wafe.android3rdlib.other.syserror;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.wafe.android3rdlib.R;

/**
 * Created by root on 10/17/17.
 */

public class OtherSysErrorActivity extends AppCompatActivity implements View.OnClickListener{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.other_syserror_main_activity);
        Button osob = (Button) findViewById(R.id.other_syserror_oom_btn);
        osob.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.other_syserror_oom_btn:
                Intent intent1 = new Intent();
                intent1.setClass(this,OtherOOMTestActivity.class);
                startActivity(intent1);
                break;
            default:
                break;
        }
    }
}
