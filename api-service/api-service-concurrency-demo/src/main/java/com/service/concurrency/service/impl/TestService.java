package com.service.concurrency.service.impl;

import com.service.concurrency.dao.TestMapper;
import com.service.concurrency.pojo.test;
import com.service.concurrency.service.TestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService implements TestServiceImpl {
    @Autowired
    private TestMapper testDao;

    @Override
    public List<test> findAll() {
        return testDao.selectAll();
    }
}
