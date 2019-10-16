package com.cn.mock.service;

/**
 * Created on 2019/10/15.
 *
 * @author hhx
 */
public class StaticTarget {
    public static int m1() {
        System.out.println("StaticTarget m1");
        throw new RuntimeException();
    }

    public static String m2() {
        System.out.println("StaticTarget m2");
        throw new RuntimeException();
    }

}
