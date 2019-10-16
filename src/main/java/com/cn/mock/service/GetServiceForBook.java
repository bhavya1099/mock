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

    public String getRes(String bookType) {

        System.out.println("GetServiceForBook getService");
        if ("novel".equals(bookType)){
            return "novel";
        }
        else {
            return "movie";
        }
    }

    public void test(String bookType){
        int type = getService(bookType);
        String res = getRes(bookType);
        System.out.println("test type:"+type);
        System.out.println("test res:"+res);
        String getDesc = getDesc(bookType);
        System.out.println(getDesc);
    }

    public String getDesc(String bookType){
        System.out.println("GetServiceForBook getDesc");
        if (bookType.equals("novel")){
            return "西游记";
        }else {
            return "电影";
        }
    }

}
