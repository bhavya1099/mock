package com.cn.mock.service;

import mockit.Mock;
import mockit.MockUp;
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
public class StaticTargetTest {

    @Test
    public void t1() {
        new MockUp<StaticTarget>() {

            @Mock
            public String m2() {
                System.out.println("mock m2");
                return "ATY";
            }

            @Mock
            public int m1() {
                System.out.println("mock m1");
                return 100;
            }
        };

        Assert.assertEquals("ATY", StaticTarget.m2());
        Assert.assertEquals(100, StaticTarget.m1());
    }
}