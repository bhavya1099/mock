package com.cn.mock.service;

import mockit.Expectations;
import mockit.Injectable;
import mockit.Mocked;
import mockit.Tested;
import mockit.integration.junit4.JMockit;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Created on 2019/10/15.
 *
 * @author hhx
 */
@RunWith(JMockit.class)
public class ServiceUseRedisTest {

    /**
     * 被引用类， 被mock
     */
    @Mocked
    @Injectable
    RedisService redisService;


    /**
     * 要测试的类
     */
    @Tested
    ServiceUseRedis serviceTested;

    @Test
    public void doSomethingReturnBooleanTest() {
        // 设置mock期望
        new Expectations(){{
            redisService.get("abc");
            result = "abc";
//            System.out.println(redisService.get("abc"));
        }};

        //执行service方法
        boolean doResult = serviceTested.doSomethingReturnBoolean("abc");

        //验证执行结果
        Assert.assertTrue(doResult);
    }
}