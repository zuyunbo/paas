package com.service.concurrency.runnable;

class RunnableImplA implements Runnable {

    private Object obj;

    public RunnableImplA(Object obj) {
        this.obj = obj;
    }

    @Override
    public void run() {
        System.out.println("run on RunnableImplA");
        synchronized (obj) {
            System.out.println("obj to wait on RunnableImplA");
            try {
                obj.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("obj continue to run on RunnableImplA");
        }
    }
}

