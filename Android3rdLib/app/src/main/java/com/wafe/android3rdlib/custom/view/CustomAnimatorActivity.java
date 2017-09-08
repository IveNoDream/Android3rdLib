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

public class CustomAnimatorActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_view_animator_activity);
        Button btnVector = (Button) findViewById(R.id.btn_anim_vector);
        Button btnMenu = (Button) findViewById(R.id.btn_anim_menu);

        btnVector.setOnClickListener(this);
        btnMenu.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_anim_vector:
                Intent intent1 = new Intent();
                intent1.setClass(this,CustomAnimatorVectorActivity.class);
                startActivity(intent1);
                break;
            case R.id.btn_anim_menu:

                break;
            default:
                break;
        }
    }
}
