package com.wafe.android3rdlib.eventbus;

/**
 * Created by root on 2/27/17.
 */
//a: create Stick Event class
public class EBStickEvent {
    private String msg;
    public EBStickEvent(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
