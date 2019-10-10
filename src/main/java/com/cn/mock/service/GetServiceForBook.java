package com.cn.mock.service;

/**
 * Created on 2019/10/10.
 *
 * @author hhx
 */
public class GetServiceForBook {
    public int getService(String bookType) {

        System.out.println("GetServiceForBook getService");
        if ("novel".equals(bookType)){
            return 1;
        }
        else {
            return 2;
        }
    }

}
