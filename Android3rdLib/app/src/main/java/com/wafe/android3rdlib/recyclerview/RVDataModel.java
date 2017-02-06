package com.wafe.android3rdlib.recyclerview;

/**
 * Created by root on 2/6/17.
 */
public class RVDataModel {
    public static final int TYPE_ONE = 1;
    public static final int TYPE_TWO = 2;
    public static final int TYPE_THREE = 3;

    private int mType;
    private int mImageRes;
    private String mTitle;
    private String mDescribtion;
    private String mTime;

    public RVDataModel(int mType, int mImageRes, String mTitle, String mDescribtion, String mTime) {
        this.mType = mType;
        this.mImageRes = mImageRes;
        this.mTitle = mTitle;
        this.mDescribtion = mDescribtion;
        this.mTime = mTime;
    }

    public RVDataModel(int mType, int mImageRes, String mTitle, String mDescribtion) {
        this.mType = mType;
        this.mImageRes = mImageRes;
        this.mTitle = mTitle;
        this.mDescribtion = mDescribtion;
    }

    public RVDataModel(int mType, int mImageRes, String mTitle) {
        this.mType = mType;
        this.mImageRes = mImageRes;
        this.mTitle = mTitle;
    }

    public int getmType() {
        return mType;
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
