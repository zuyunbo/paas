package com.service.concurrency.runnable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest {


    public static void main(String[] args) {

        Map<String, Object> returnMap = new HashMap<>();

        Callable<List> callable = ArrayList::new;

        Callable<List> callable1 = ArrayList::new;

        Callable<List<String>> callable2 = () -> null;

        FutureTask<List> futureTask = new FutureTask<>(callable);
        FutureTask<List> futureTask2= new FutureTask<>(callable1);
        FutureTask<List<String>> listFutureTask = new FutureTask<>(callable2);

        Thread t1 = new Thread(futureTask);
        Thread t2 = new Thread(futureTask2);
        Thread t3 = new Thread(listFutureTask);
        t1.start(); //开始线程
        t2.start();
        t3.start();

        try {
            List list1 = futureTask.get();
            List list2 = futureTask2.get();
            List list3 = listFutureTask.get();
            returnMap.put("list1",list1);
            returnMap.put("list2",list2);
            returnMap.put("list3",list3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }finally {
            t1.interrupt(); //关闭线程
            t2.interrupt();
            t3.interrupt();
        }
  }
}
