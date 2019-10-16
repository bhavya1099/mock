package com.cn.mock.service;

/**
 * Created on 2019/10/15.
 *
 * @author hhx
 */
public class RedisService {
    public String get(String key) {
        throw new RuntimeException("I'm redis service, you can not call me in unit test");
    }
}
