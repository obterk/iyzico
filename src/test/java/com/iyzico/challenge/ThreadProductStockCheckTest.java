package com.iyzico.challenge;

import com.iyzico.challenge.interceptor.ThreadProductStockCheck;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class ThreadProductStockCheckTest {

    @Before
    public void init() {

    }

    @Test
    public void runTest() {
        ThreadProductStockCheck thread = new ThreadProductStockCheck(Mockito.anyString());
        thread.run();
    }

}
