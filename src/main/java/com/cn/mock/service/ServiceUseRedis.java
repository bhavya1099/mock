package com.cn.mock.service;

/**
 * Created on 2019/10/15.
 *
 * @author hhx
 */
public class ServiceUseRedis {
    private RedisService redisService;

    public boolean doSomethingReturnBoolean(String someArg) {
        String somethingInRedis = redisService.get(someArg);
        System.out.println("ServiceUseRedis somethingInRedis===="+somethingInRedis);
        return someArg.equals(somethingInRedis);
    }
}
