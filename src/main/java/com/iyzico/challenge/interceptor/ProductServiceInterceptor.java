package com.iyzico.challenge.interceptor;


import com.iyzico.challenge.entity.Product;
import com.iyzico.challenge.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Component
public class ProductServiceInterceptor implements HandlerInterceptor {

    @Autowired
    ProductService productService;
    private static int numberOfActiveClients = 0;

    @Override
    public boolean preHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        List<Product> productList = productService.checkProductStocks(Long.valueOf(request.getParameter("productId")));
        numberOfActiveClients++;
        ThreadProductStockCheck thread = new ThreadProductStockCheck("");
        ThreadProductStockCheck.mutex.release(productList.size()); // give any number customer permission to as stock size
        thread.start();
        return true;
    }
    @Override
    public void postHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {}

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception exception) throws Exception {
        numberOfActiveClients--;
    }
}