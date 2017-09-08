package com.wafe.android3rdlib.custom.view;

import android.app.Activity;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.wafe.android3rdlib.R;

/**
 * Created by root on 9/8/17.
 */

public class CustomAnimatorVectorActivity extends Activity {
    private ImageView iv;
    private ImageView ivEarth;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_view_anim_vector_activity);

        iv = (ImageView) findViewById(R.id.iv_custom_view_vector_test);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animate();
            }
        });

        ivEarth = (ImageView) findViewById(R.id.iv_custom_view_vector_test_earth);
        ivEarth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animateEarth();
            }
        });
    }

    private void animateEarth() {
        Drawable drawable = ivEarth.getDrawable();
        if (drawable instanceof Animatable) {
            ((Animatable)drawable).start();
        }
    }

    private void animate() {
        Drawable drawable = iv.getDrawable();
        if (drawable instanceof Animatable) {
            ((Animatable)drawable).start();
        }
    }
}
