package com.wafe.android3rdlib.frame.xml.data;

/**
 * Created by wafej on 2018/4/30.
 */

public class XMLB extends XMLBase {
    private int mStep;

    public XMLB(String name,int type, int mStep) {
        mName = name;
        mType = type;
        this.mStep = mStep;
    }

    public int getmStep() {
        return mStep;
    }

    public void setmStep(int mStep) {
        this.mStep = mStep;
    }
}
