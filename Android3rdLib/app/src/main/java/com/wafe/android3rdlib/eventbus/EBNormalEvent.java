package com.wafe.android3rdlib.eventbus;

/**
 * Created by root on 2/27/17.
 */
//1.create normal Event class
public class EBNormalEvent {
    private String msg;
    public EBNormalEvent(String message) {
        this.msg = message;
    }

    public String getMsg() {
        return msg;
    }
}
