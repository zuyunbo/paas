package com.service.concurrency.runnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ShutdownTest {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 5; i++) {
            String str = i + "";
            service.execute(() -> {
                System.out.println(str);
            });
        }
        // shutdown() 和 awaitTermination() 组合使用
        service.shutdown();
        service.awaitTermination(1, TimeUnit.MINUTES);
        System.out.println("线程池已关闭");
    }

}
