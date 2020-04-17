package com.service.concurrency.runnable;


class RunnableImplC implements Runnable {

    private Object obj;

    public RunnableImplC(Object obj) {
        this.obj = obj;
    }

    @Override
    public void run() {
        System.out.println("run on RunnableImplC");
        System.out.println("睡眠3秒...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (obj) {
            System.out.println("notifyAll obj on RunnableImplC");
            obj.notifyAll();
        }
    }
}

