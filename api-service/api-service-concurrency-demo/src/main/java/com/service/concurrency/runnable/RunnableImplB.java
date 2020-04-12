package com.service.concurrency.runnable;

class RunnableImplB implements Runnable {

    private Object obj;

    public RunnableImplB(Object obj) {
        this.obj = obj;
    }

    @Override
    public void run() {
        System.out.println("run on RunnableImplB");
        System.out.println("睡眠3秒...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (obj) {
            System.out.println("notify obj on RunnableImplB");
            obj.notify();
        }
    }
}

