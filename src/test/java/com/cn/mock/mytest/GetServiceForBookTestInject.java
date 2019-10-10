package com.cn.mock.mytest;

import com.cn.mock.service.GetServiceForBook;
import mockit.Expectations;
import mockit.Injectable;
import mockit.integration.junit4.JMockit;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * Created on 2019/10/10.
 *
 * @author hhx
 */
@RunWith(JMockit.class)
public class GetServiceForBookTestInject {
    @Injectable
    private GetServiceForBook getServiceForBook;

    @Test
    public void testBookService() {

        new Expectations() {
            {
                getServiceForBook.getService(anyString);
                result = 3;
                times = 1;
            }
        };

        int test = getServiceForBook.getService("test");
        assertEquals(3, test);
    }
}
