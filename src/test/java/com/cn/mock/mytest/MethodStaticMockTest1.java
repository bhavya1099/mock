package com.cn.mock.mytest;

import com.cn.mock.service.MethodClass;
import mockit.Expectations;
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
public class MethodStaticMockTest1 {
    @Test
    public void test_mockPublicStatic1()
    {
        //mock静态方法，所以这里可以用类对象
        new Expectations(MethodClass.class)
        {
            {
                MethodClass.publicStaticMethod();
                result = "Mocked public static method";
            }
        };

        System.out.println(MethodClass.publicStaticMethod());//Mocked public static method

        //原有public方法不会被mock
        MethodClass obj = new MethodClass();
        System.out.println(obj.publicMethod());// Original public Method !
    }
}
