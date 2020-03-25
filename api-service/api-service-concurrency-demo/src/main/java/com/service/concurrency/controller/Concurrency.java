package com.service.concurrency.controller;

import com.service.concurrency.runnable.MyRunnable;
import com.service.concurrency.runnable.counter;
import com.service.concurrency.service.TestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin
@RequestMapping("/test")
public class Concurrency {

    @Autowired
    private TestServiceImpl testServiceImpl;


    @GetMapping("/demo")
    public void test() {
        counter counter = new counter();
        MyRunnable myRunnable1 = new MyRunnable(counter);
        Thread thread1 = new Thread(myRunnable1);
        Thread thread2 = new Thread(myRunnable1);
        thread1.start();
        thread2.start();
    }

}
