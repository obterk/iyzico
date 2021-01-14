package com.iyzico.challenge.service;

import com.iyzico.challenge.entity.Product;
import com.iyzico.challenge.model.ProductRequest;
import com.iyzico.challenge.repository.ProductRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static com.iyzico.challenge.service.util.Helper.createMock;
import static com.iyzico.challenge.service.util.Helper.createMockProduct;

public class ProductServiceTest {

    private ProductRepository productRepository;
    private ProductService productService;
    private ProductRequest productRequest;

    @Before
    public void init() {
        productRepository = createMock(ProductRepository.class);
        productService = new ProductServiceImpl(productRepository);
        productRequest = createMockProduct();
    }

    @Test
    public void addProductTest() {
        productService.addProduct(productRequest);
        Mockito.when(productRepository.save(new Product())).thenReturn(new Product());
    }

    @Test
    public void deleteProductTest() {
        productService.deleteProduct(Mockito.anyLong());
    }

    @Test
    public void updateProductTest() {
        Mockito.when(productRepository.getOne(productRequest.getProductId())).thenReturn(new Product());
        productService.updateProduct(productRequest);
    }

    @Test
    public void allProductTest() {
        productService.allProducts();
    }

    @Test
    public void getProductTest() {
        Product product1 = new Product();
        product1.setProductName("iyzico card");
        Mockito.when(productRepository.findByProductName(Mockito.anyString())).thenReturn(product1);
        Product product2 = new Product();
        product2.setProductName("iyzico card");
        Assert.assertEquals(product1.getProductName(),productService.getProduct(Mockito.anyString()).getProductName());
    }

    @Test
    public void checkProductAvailabilityTest() {
        Product product1 = new Product();
        product1.setProductName("iyzico card");
        Mockito.when(productRepository.findByProductName(Mockito.anyString())).thenReturn(product1);
        Product product2 = new Product();
        product2.setProductName("iyzico card");
        Assert.assertEquals(product1.getProductName(),productService.getProduct(Mockito.anyString()).getProductName());
    }

    @Test
    public void checkProductStocksTest() {
        productRepository.findAllByProductId(Mockito.anyLong());
    }
}
