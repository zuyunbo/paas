package com.service.concurrency.runnable;

public class TestNotifyNotifyAll {
    private static Object obj = new Object();

    public static void main(String[] args) {

        //测试 RunnableImplA wait()
        Thread t1 = new Thread(new RunnableImplA(obj));
        Thread t2 = new Thread(new RunnableImplA(obj));
        t1.start();
        t2.start();

        //RunnableImplB notify()
        Thread t3 = new Thread(new RunnableImplB(obj));
        t3.start();


        //RunnableImplC notifyAll()
        Thread t4 = new Thread(new RunnableImplC(obj));
        t4.start();
    }


}
