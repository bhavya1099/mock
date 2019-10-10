package com.cn.mock.mytest;

import com.cn.mock.service.GetServiceForBook;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created on 2019/10/10.
 *
 * @author hhx
 */
public class GetServiceForBookTest {
    private GetServiceForBook getServiceForBook = new GetServiceForBook();

    @Test
    public void testBookService() {

        int test = getServiceForBook.getService("novel");

        assertEquals(1,test);
    }

}
