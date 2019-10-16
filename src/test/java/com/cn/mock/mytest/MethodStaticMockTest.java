package com.cn.mock.mytest;

import com.cn.mock.service.MethodClass;
import mockit.Mocked;
import mockit.integration.junit4.JMockit;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created on 2019/10/15.
 *
 * @author hhx
 */
@RunWith(JMockit.class)
public class MethodStaticMockTest {
    @Test
    public void test_mockPublicStatic2(@Mocked final MethodClass c)
    {
        System.out.println(MethodClass.publicStaticMethod());//null

        MethodClass obj = new MethodClass();
        System.out.println(obj.publicMethod());// null
    }
}
