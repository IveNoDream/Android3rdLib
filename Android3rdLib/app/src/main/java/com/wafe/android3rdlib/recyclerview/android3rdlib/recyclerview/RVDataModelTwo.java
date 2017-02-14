package com.wafe.android3rdlib.recyclerview.android3rdlib.recyclerview;

/**
 * Created by root on 2/6/17.
 */
public class RVDataModelTwo {
    private int mImageRes;
    private String mTitle;
    private String mDescribtion;

    public RVDataModelTwo(int mImageRes, String mTitle, String mDescribtion) {
        this.mImageRes = mImageRes;
        this.mTitle = mTitle;
        this.mDescribtion = mDescribtion;
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
}
