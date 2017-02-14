package com.wafe.android3rdlib.recyclerview.android3rdlib.recyclerview;

/**
 * Created by root on 2/6/17.
 */
public class RVDataModelOne {
    private int mImageRes;
    private String mTitle;
    private String mDescribtion;
    private String mTime;

    public RVDataModelOne(int mImageRes, String mTitle, String mDescribtion, String mTime) {
        this.mImageRes = mImageRes;
        this.mTitle = mTitle;
        this.mDescribtion = mDescribtion;
        this.mTime = mTime;
    }

    public int getmImageRes() {
        return mImageRes;
    }

    public String getmTitle() {
        return mTitle;
    }

    public String getmDescribtion() {
        return mDescribtion;
    }

    public String getmTime() {
        return mTime;
    }
}
