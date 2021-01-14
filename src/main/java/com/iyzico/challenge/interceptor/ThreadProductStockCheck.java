package com.iyzico.challenge.interceptor;

import com.iyzico.challenge.service.ProductServiceImpl;
import lombok.SneakyThrows;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;

public class ThreadProductStockCheck extends Thread {

    private static final Log logger = LogFactory.getLog(ThreadProductStockCheck.class);

    public static Semaphore mutex = new Semaphore(1);

    private String customerName = "";

    public ThreadProductStockCheck(String customerName) {
        this.customerName = customerName;
    }

    final ExecutorService es = Executors.newSingleThreadExecutor();

    @SneakyThrows
    @Override
    public void run() {
        try {

            logger.info("How many people can buy a product at a time: " + mutex.availablePermits());
            logger.info(customerName + " is buying a product...");
            mutex.acquire();
            Future mutexWait = es.submit(() -> mutex.release());
            mutexWait.get();
            try {
                Thread.sleep(1000);
                logger.info(customerName + " is still buying a product. How many people can still buy the product alongside him: " + mutex.availablePermits());
            } finally {
                mutex.release();
                logger.info(customerName + " bought the product.");
                logger.info("How many people can buy product after " + customerName + " has finished buying the product: " + mutex.availablePermits());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Runtime.getRuntime().addShutdownHook(new Thread(() -> es.shutdownNow()));

    }

}


