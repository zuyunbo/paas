package com.cloud;


import com.cloud.text.JdbcConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping
public class Test1 {

    @Autowired
    private JdbcConfig jdbcConfig;

    @GetMapping("/test")
    public List<String> principal() {
        List<String> test = jdbcConfig.initTableInfo("test");
        return test;
    }

}
