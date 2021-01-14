package com.iyzico.challenge.service;

import com.iyzico.challenge.model.BankPaymentRequest;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static com.iyzico.challenge.service.util.Helper.createMock;

public class PaymentServiceClientsTest {

    private IyzicoPaymentService iyzicoPaymentService;
    private PaymentServiceClients paymentServiceClients;

    @Before
    public void init() {
        iyzicoPaymentService = createMock(IyzicoPaymentService.class);
        paymentServiceClients = new PaymentServiceClients(iyzicoPaymentService);
    }

    @Test
    public void callTest() {
        paymentServiceClients.call(new BigDecimal(56));
    }

}
