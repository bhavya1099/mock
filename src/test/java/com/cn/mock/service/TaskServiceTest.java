package com.cn.mock.service;

import mockit.Expectations;
import mockit.integration.junit4.JMockit;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created on 2019/10/15.
 *
 * @author hhx
 */
@RunWith(JMockit.class)
public class TaskServiceTest {

    @Test
    public void canExecute() {
        final Calendar cal = Calendar.getInstance();
        cal.set(2015, Calendar.NOVEMBER, 28, 10, 10, 0);

        //mock
        new Expectations(){{
            //指定要mock的方法
            System.currentTimeMillis();

            //指定mock方法要返回的结果
            result =  cal.getTime().getTime();
//            System.out.println("mock result="+result);
        }};

        cal.set(2015, Calendar.NOVEMBER, 28, 15, 0, 0);
        Date createTime = cal.getTime();
        //执行方法逻辑
        TaskService taskService = new TaskService();
        boolean canExecute = taskService.canExecute(createTime);

        //验证是否符合预期
        Assert.assertTrue(canExecute);
    }
}