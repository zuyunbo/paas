package com.service.concurrency.runnable;

import java.util.ArrayList;
import java.util.List;

public class Something {
    private Buffer mBuf = new Buffer();

    public void produce() {
        System.out.println("object on RunnableImplB");

        synchronized (this) {
            System.out.println("synchronized on RunnableImplB");

            while (mBuf.isFull()) {
                try {
                    System.out.println("wait on RunnableImplB");
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("add on RunnableImplB");

            mBuf.add();
            notifyAll();
        }
    }

    public void consume() {
        System.out.println("object on RunnableImplA");
        synchronized (this) {
            System.out.println("synchronized on RunnableImplA");
            while (mBuf.isEmpty()) {
                try {
                    System.out.println("wait on RunnableImplA");

                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("remove on RunnableImplA");

            mBuf.remove();
            notifyAll();
        }
    }

    private class Buffer {
        private static final int MAX_CAPACITY = 1;
        private List innerList = new ArrayList<>(MAX_CAPACITY);

        void add() {
            if (isFull()) {
                throw new IndexOutOfBoundsException();
            } else {
                innerList.add(new Object());
            }
            System.out.println(Thread.currentThread().toString() + " add11");

        }

        void remove() {
            if (isEmpty()) {
                throw new IndexOutOfBoundsException();
            } else {
                innerList.remove(MAX_CAPACITY - 1);
            }
            System.out.println(Thread.currentThread().toString() + "  remove");
        }

        boolean isEmpty() {
            System.out.println(Thread.currentThread().toString() + " 我唯恐");
            return innerList.isEmpty();
        }

        boolean isFull() {
            return innerList.size() == MAX_CAPACITY;
        }
    }

    public static void main(String[] args) {
        Something sth = new Something();
        Runnable runProduce = new Runnable() {
            int count = 1;

            @Override
            public void run() {
                System.out.println("run on RunnableImplB");
                while (count-- > 0) {
                    sth.produce();
                }
            }
        };
        Runnable runConsume = new Runnable() {
            int count = 1;

            @Override
            public void run() {
                System.out.println("run on RunnableImplA");
                while (count-- > 0) {
                    sth.consume();
                }
            }
        };

            new Thread(runConsume).start();
            new Thread(runConsume).start();
            new Thread(runProduce).start();
            new Thread(runProduce).start();

    }
}
