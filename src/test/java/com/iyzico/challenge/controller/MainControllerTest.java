package com.iyzico.challenge.controller;

import com.iyzico.challenge.controller.MainController;
import com.iyzico.challenge.entity.Product;
import com.iyzico.challenge.model.ProductRequest;
import com.iyzico.challenge.service.IyzicoPaymentService;
import com.iyzico.challenge.service.ProductService;
import com.iyzico.challenge.service.util.Helper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static com.iyzico.challenge.service.util.Helper.createMock;
import static com.iyzico.challenge.service.util.Helper.createMockProduct;

public class MainControllerTest {

    private ProductService productService;
    private IyzicoPaymentService iyzicoPaymentService;
    private Product productMock = createMock(Product.class);
    private MainController mainController;
    private ProductRequest productRequest;


    @Before
    public void init() {
        productService = createMock(ProductService.class);
        iyzicoPaymentService = createMock(IyzicoPaymentService.class);
        mainController = new MainController(productService, iyzicoPaymentService);
        productRequest = createMockProduct();
    }

    @Test
    public void addProductTest() {
        mainController.addProduct(productRequest);
    }

    @Test
    public void updateProductTest() {
        mainController.updateProduct(productRequest);
    }

    @Test
    public void deleteProductTest() {
        mainController.deleteProduct(Mockito.anyLong());
    }

    @Test
    public void getProductTest() {
        mainController.getProduct(Mockito.anyString());
    }

    @Test
    public void buyProductTest() throws Exception {
        mainController.buyProduct(productRequest);
    }






}
