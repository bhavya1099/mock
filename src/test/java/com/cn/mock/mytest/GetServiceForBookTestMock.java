package com.cn.mock.mytest;

import com.cn.mock.service.GetServiceForBook;
import mockit.Mock;
import mockit.MockUp;
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
public class GetServiceForBookTestMock {
//    private GetServiceForBook getServiceForBook = new GetServiceForBook();

    @Test
    public void testBookService() {

        new MockUp<GetServiceForBook>(){
            @Mock
            public int getService(String bookType)
            {
                System.out.println("mock getService");
                return 3;
            }

            @Mock
            public String getRes(String bookType) {
                System.out.println("mock getRes");
                return "novel";
            }
        };

        GetServiceForBook getServiceForBook = new GetServiceForBook();

        getServiceForBook.test("novel");

//        int test = getServiceForBook.getService("novel");
//        String res = getServiceForBook.getRes("movie");
//        System.out.println("res:"+res);
//        assertEquals(3,test);
//        assertEquals("novel",res);
    }
}
