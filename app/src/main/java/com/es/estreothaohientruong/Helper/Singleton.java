package com.es.estreothaohientruong.Helper;

/**
 * Created by My_PC on 8/30/2017.
 */

public class Singleton {
    private static final Singleton singleton = new Singleton();
    public String IPAddress;

    public static Singleton getInstance() {
        return singleton;
    }

    private Singleton() {
    }
}
