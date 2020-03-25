package com.service.concurrency.runnable;


public class counter {

    long count = 100;

    public void add() throws InterruptedException {
        boolean a = true;
        while (a) {
            if (count == 0) {
                a = false;
            }
            wait(500);
            count--;
            System.out.println(Thread.currentThread().getName() + " : " + count);
        }
    }
}
