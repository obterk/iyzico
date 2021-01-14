package com.iyzico.challenge.service.util;

import com.iyzico.challenge.model.ProductRequest;
import org.mockito.Mockito;

import java.math.BigDecimal;

public class Helper {

    public static  <T> T createMock(Class<T> classToMock) {
        return Mockito.mock(classToMock);
    }

    public static ProductRequest createMockProduct() {
        ProductRequest productRequest = new ProductRequest();
        productRequest.setCount(1);
        productRequest.setDescription("desc product");
        productRequest.setPrice(new BigDecimal(56));
        productRequest.setProductId(3L);
        productRequest.setRemainingStock(1000L);
        productRequest.setProductName("Iyzico Credit Card");
        return productRequest;
    }

}
