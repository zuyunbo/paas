package com.service.concurrency.runnable;


import lombok.SneakyThrows;

public class MyRunnable implements Runnable {

    private counter counter = null;

    public MyRunnable(counter counter) {
        this.counter = counter;
    }

    @SneakyThrows
    @Override
    public void run() {
        counter.add();
    }
}
