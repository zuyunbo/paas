package com.service.concurrency.service;

import com.service.concurrency.pojo.test;

import java.util.List;

public interface TestServiceImpl {
    List<test> findAll();
}
