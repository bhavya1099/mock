package com.cn.mock.mytest;

import mockit.Mock;
import mockit.MockUp;
import mockit.integration.junit4.JMockit;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Calendar;
import java.util.Locale;

/**
 * Created on 2019/10/10.
 *
 * @author hhx
 */
@RunWith(JMockit.class)
public class MockUpTest {
    @Test
    public void testMockUp(){
        /*
         * 对java自带类Calendar的get方法进行定制
         * 只需要把Calendar类传入MockUp类的构造函数即可
         * */
        new MockUp<Calendar>(Calendar.class){

            //想mock哪个方法，就给哪个方法加上@Mock，没有@Mock的方法，不受影响
            @Mock
            public int get(int unit){
                System.out.println("inner class Calendar");
                if (unit == Calendar.YEAR){
                    return 2017;
                }
                if (unit == Calendar.MONDAY){
                    return 12;
                }
                if (unit == Calendar.DAY_OF_MONTH){
                    return 25;
                }
                if (unit == Calendar.HOUR_OF_DAY){
                    return 7;
                }
                return 0;
            }
        };
        // 从此Calendar的get方法，就沿用你定制过的逻辑，而不是它原先的逻辑。
        Calendar cal = Calendar.getInstance(Locale.FRANCE);
        Assert.assertTrue(cal.get(Calendar.YEAR) == 2017);
        Assert.assertTrue(cal.get(Calendar.MONDAY) == 12);
        Assert.assertTrue(cal.get(Calendar.DAY_OF_MONTH) == 25);
        Assert.assertTrue(cal.get(Calendar.HOUR_OF_DAY) == 7);
        // Calendar的其它方法，不受影响
        Assert.assertTrue((cal.getFirstDayOfWeek() == Calendar.MONDAY));
    }
}
