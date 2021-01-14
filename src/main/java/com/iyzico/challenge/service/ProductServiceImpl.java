package com.iyzico.challenge.service;

import com.iyzico.challenge.entity.Product;
import com.iyzico.challenge.model.ProductRequest;
import com.iyzico.challenge.model.ProductResponse;
import com.iyzico.challenge.repository.ProductRepository;
import lombok.SneakyThrows;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements  ProductService {

    private static final Log logger = LogFactory.getLog(ProductServiceImpl.class);

    private ProductRepository productRepository;


    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product addProduct(ProductRequest productRequest) {
        Product product = new Product();
        product.setCount(productRequest.getCount());
        product.setDescription(productRequest.getDescription());
        product.setPrice(productRequest.getPrice());
        product.setProductName(productRequest.getProductName());
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product updateProduct(ProductRequest productRequest) {
        Product product = productRepository.getOne(productRequest.getProductId());
        product.setCount(productRequest.getCount());
        product.setDescription(productRequest.getDescription());
        product.setPrice(productRequest.getPrice());
        product.setProductName(productRequest.getProductName());
        return productRepository.save(product);
    }

    @Override
    public List<Product> allProducts() {
        return productRepository.findAll();
    }

    @Override
    public ProductResponse getProduct(String productName) {
        Product product = productRepository.findByProductName(productName);
        ModelMapper modelMapper = new ModelMapper();
        ProductResponse productResponse = modelMapper.map(product, ProductResponse.class);
        return productResponse;
    }

    @Override
    public boolean checkProductAvailability(long productId) {
        Product product = productRepository.getOne(productId);
        return product != null ? true : false;
    }

    @Override
    public List<Product> checkProductStocks(long productId) throws Exception {
        return productRepository.findAllByProductId(productId);
    }

}
