package com.iyzico.challenge.service;

import com.iyzico.challenge.entity.Product;
import com.iyzico.challenge.model.ProductRequest;
import com.iyzico.challenge.model.ProductResponse;
import java.util.List;
import java.util.Optional;

public interface ProductService {

    Product addProduct(ProductRequest product);

    void deleteProduct(long id);

    Product updateProduct(ProductRequest product);

    List<Product> allProducts();

    ProductResponse getProduct(String productName);

    boolean checkProductAvailability(long productId);

    List<Product> checkProductStocks(long productId) throws Exception;
}
