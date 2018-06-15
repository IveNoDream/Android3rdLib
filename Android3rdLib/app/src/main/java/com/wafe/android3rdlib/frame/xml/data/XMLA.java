package com.wafe.android3rdlib.frame.xml.data;

/**
 * Created by wafej on 2018/4/30.
 */

public class XMLA extends XMLBase {
    private float mSpeed;

    public XMLA(String name, int type, float mSpeed) {
        mName = name;
        mType = type;
        this.mSpeed = mSpeed;
    }

    public float getmSpeed() {
        return mSpeed;
    }

    public void setmSpeed(float mSpeed) {
        this.mSpeed = mSpeed;
    }
}
