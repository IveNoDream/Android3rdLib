package com.wafe.android3rdlib.frame.bmob;

import cn.bmob.v3.BmobObject;

/**
 * Created by root on 8/8/17.
 */

public class FrameBmobPerson extends BmobObject {
    private String name;
    private String address;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
}
