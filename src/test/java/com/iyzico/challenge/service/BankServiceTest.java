package com.iyzico.challenge.service;

import com.iyzico.challenge.controller.MainController;
import com.iyzico.challenge.model.BankPaymentRequest;
import org.junit.Before;
import org.junit.Test;

import static com.iyzico.challenge.service.util.Helper.createMock;
import static com.iyzico.challenge.service.util.Helper.createMockProduct;

public class BankServiceTest {

    private BankPaymentRequest bankPaymentRequest;
    private BankService bankService;
    @Before
    public void init() {
        bankService = new BankService();
        bankPaymentRequest = createMock(BankPaymentRequest.class);    }

    @Test
    public void payTest() {
        bankService.pay(bankPaymentRequest);
    }

}
