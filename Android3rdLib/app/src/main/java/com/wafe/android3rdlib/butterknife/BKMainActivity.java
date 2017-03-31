package com.wafe.android3rdlib.butterknife;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.wafe.android3rdlib.R;
import com.wafe.android3rdlib.util.LogUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.wafe.android3rdlib.R.*;

/**
 * Created by root on 3/31/17.
 * Official addr: http://jakewharton.github.io/butterknife/
 * github addr: https://github.com/JakeWharton/butterknife/
 *
 * 1.AndroidStudio->Settings->Plugins->search "ButterKnife"->if shown null blow,
 *  click Browser->install Android ButterKnife Zelezny->build Project
 * 2.add app gradle:
 *      apply plugin: 'android-apt'
 *    dependencies:
 *      compile 'com.jakewharton:butterknife:8.2.1'
 *      apt 'com.jakewharton:butterknife-compiler:8.2.1'
 * 3.add Module gradle:
 *    dependencies
 *      classpath 'com.neenbedankt.gradle.plugins:android-apt:1.8' //add by using butterknife
 * 4.after setContetView(), use ButterKnife.bind(this); //
 */
public class BKMainActivity extends AppCompatActivity {
    @BindView(id.bk_tv)
    TextView mTv;

    @BindView(id.bk_cb)
    CheckBox mCb;

    @BindView(id.bk_btn)
    Button mBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.bk_activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(id.bk_btn)
    void btnClick(View v) {
        Toast.makeText(BKMainActivity.this, getResources().getString(string.bk_button_click_toast),Toast.LENGTH_SHORT).show();
        mTv.setText("Butterknife run");
    }

    @OnClick(id.bk_cb)
    void cbClick(View v) {
        if (mCb.isChecked()) {
            Toast.makeText(BKMainActivity.this, getResources().getString(string.bk_cb_check_on_toast), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(BKMainActivity.this, getResources().getString(string.bk_cb_check_off_toast), Toast.LENGTH_SHORT).show();
        }
    }
}
