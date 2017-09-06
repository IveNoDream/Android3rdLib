package com.wafe.android3rdlib.custom.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.wafe.android3rdlib.R;

/**
 * Created by root on 8/8/17.
 */

public class CustomViewActivity extends AppCompatActivity implements View.OnClickListener{
    private Button mBtn2D = null;
    private Button mBtnShape = null;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_view_test_activity);
        mBtn2D = (Button) findViewById(R.id.btn_2d);
        mBtn2D.setOnClickListener(this);
        mBtnShape = (Button) findViewById(R.id.btn_shape);
        mBtnShape.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_2d:
                Intent intent = new Intent(CustomViewActivity.this,CustomView2DActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                this.startActivity(intent);
                break;
            case R.id.btn_shape:
                Intent intent1 = new Intent(CustomViewActivity.this,CustomViewShapeActivity.class);
                intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                this.startActivity(intent1);
                break;
            default:

                break;
        }
    }
}
