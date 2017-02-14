package com.wafe.android3rdlib.main;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by root on 2/6/17.
 */
public class MainRVDataModel {
    private Class<? extends AppCompatActivity> mActivity;
    private int mTitle;
    private int mDescribtion;
    public MainRVDataModel(Class<? extends AppCompatActivity> activity, int title, int describtion) {
        this.mActivity = activity;
        this.mTitle = title;
        this.mDescribtion = describtion;
    }

    public Class<? extends AppCompatActivity> getActivity() {
        return mActivity;
    }

    public int getTitle() {
        return mTitle;
    }

    public int getDescribtion() {
        return mDescribtion;
    }
}
