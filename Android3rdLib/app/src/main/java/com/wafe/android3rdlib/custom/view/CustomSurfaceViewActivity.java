package com.wafe.android3rdlib.custom.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.wafe.android3rdlib.R;

/**
 * Created by root on 9/8/17.
 */

public class CustomSurfaceViewActivity extends AppCompatActivity implements View.OnClickListener{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_view_surfaceview_activity);

        Button btnSin = (Button) findViewById(R.id.btn_sin);
        Button btnDrawMap = (Button) findViewById(R.id.btn_draw_map);
        btnSin.setOnClickListener(this);
        btnDrawMap.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_sin:
                Intent intent1 = new Intent();
                intent1.setClass(this,CustomSurfaceViewSimpleActivity.class);
                intent1.putExtra("custom_class","sin");
                this.startActivity(intent1);
                break;
            case R.id.btn_draw_map:
                Intent intent2 = new Intent();
                intent2.setClass(this,CustomSurfaceViewSimpleActivity.class);
                intent2.putExtra("custom_class","draw");
                this.startActivity(intent2);
                break;
            default:
                break;
        }
    }
}
