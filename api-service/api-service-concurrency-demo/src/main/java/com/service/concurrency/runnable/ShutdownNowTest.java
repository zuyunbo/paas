package com.service.concurrency.runnable;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ShutdownNowTest {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(2);
        for (int i = 1; i <= 5; i++) {
            String str = i + "";
            service.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(str);
                }

                // 为了后面展示未执行的任务，这里重写toString()方法
                @Override
                public String toString() {
                    return "这是第" + str + "个任务";
                }
            });
        }
        // 没有来得及执行的任务会以列表的形式返回
        List<Runnable> runnables = service.shutdownNow();
        System.out.println("线程池已关闭");
        for (Runnable runnable : runnables) {
            // 打印一下未执行的任务
            System.out.println(runnable);
        }
    }
}
