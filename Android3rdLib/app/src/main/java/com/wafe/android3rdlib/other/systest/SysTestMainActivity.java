package com.wafe.android3rdlib.other.systest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.wafe.android3rdlib.R;


public class SysTestMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.other_systest_main);
    }

    public void btnAM(View view) {
        startActivity(new Intent(this, AMProcessTest.class));
    }

    public void btnPM(View view) {
        startActivity(new Intent(this, PMTest.class));
    }
}
