package com.siasun.lib;

public class myClass {
    public static void main(String[] args) {
        int a = 0xaa;
        System.out.println("ssss");
        byte b = (byte)a;
        String s = Integer.toHexString(b & 0xFF);
        System.out.println(s);
    }
}
