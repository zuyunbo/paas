package com.zuul.gatewayzuul.controller;

import com.zuul.gatewayzuul.feign.Oauth2Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service")
public class TestController {

    @Autowired
    Oauth2Client oauth2Client;

    @RequestMapping("/hello")
    public String index() {
        return oauth2Client.hello("3");
    }

}
