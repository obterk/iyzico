package com.iyzico.challenge.controller;

import com.iyzico.challenge.entity.Product;
import com.iyzico.challenge.model.ProductRequest;
import com.iyzico.challenge.model.ProductResponse;
import com.iyzico.challenge.service.BankService;
import com.iyzico.challenge.service.IyzicoPaymentService;
import com.iyzico.challenge.service.ProductService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/iyzico")
public class MainController {

    private static final Log logger = LogFactory.getLog(MainController.class);
    private ProductService productService;
    private IyzicoPaymentService iyzicoPaymentService;

    @Autowired
    public MainController(ProductService productService, IyzicoPaymentService iyzicoPaymentService){
        this.productService = productService;
        this.iyzicoPaymentService = iyzicoPaymentService;
    }

    @PostMapping(value = "/add-product")
    public @ResponseBody String addProduct(@RequestBody ProductRequest product) {
        long startTime = System.currentTimeMillis();
        logger.trace("add product started. - " + startTime);
        productService.addProduct(product);
        logger.trace("add product -  finished!" + (System.currentTimeMillis() - startTime));
        return "test";
    }

    @PostMapping(value = "/update-product")
    public @ResponseBody String updateProduct(@RequestBody ProductRequest productRequest) {
        long startTime = System.currentTimeMillis();
        logger.trace("add product started. - " + startTime);
        productService.updateProduct(productRequest);
        logger.trace("add product -  finished!" + (System.currentTimeMillis() - startTime));
        return "test";
    }

    @DeleteMapping(value = "delete-product/{id}")
    public @ResponseBody String deleteProduct(@PathVariable long id) {
        long startTime = System.currentTimeMillis();
        logger.trace("delete product started. - " + startTime);
        productService.deleteProduct(id);
        logger.trace("delete product -  finished!" + (System.currentTimeMillis() - startTime));
        return "test";
    }

    @GetMapping("/product")
    public @ResponseBody
    ProductResponse getProduct(@RequestParam String productName) {
        long startTime = System.currentTimeMillis();
        logger.trace("get product started. - " + startTime);
        ProductResponse product = productService.getProduct(productName);
        logger.trace("get product -  finished!" + (System.currentTimeMillis() - startTime));
        return product;
    }

    @PostMapping("/buy-product")
    public ResponseEntity<String> buyProduct(@RequestBody ProductRequest productRequest) throws Exception {
        // before paying product interceptor will intervene at this point then will check stock size via number of clients
            iyzicoPaymentService.pay(productRequest.getPrice());
            return new ResponseEntity<>(
                    "Your payment has been successfully completed...",
                    HttpStatus.OK);
    }
}
