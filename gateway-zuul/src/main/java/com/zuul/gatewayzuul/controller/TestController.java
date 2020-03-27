package com.zuul.gatewayzuul.controller;

import com.cloud.common.Oauth2Enum;
import com.zuul.gatewayzuul.feign.Oauth2Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/sys")
public class TestController {

    @Autowired
    Oauth2Client oauth2Client;

    @RequestMapping("/hello")
    public String index() {
        return oauth2Client.hello("3");
    }

    @RequestMapping("test")
    public String test(){
        return "test" ;
    }


    /**
     *
     *  采用oauth2授权码模式获取access_token
     * @param code 第三方登陆获取token
     * @return access_token
     */
    @PostMapping("/token/{code}")
    public Map<String, Object> login(@PathVariable String code) {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("grant_type", "authorization_code");
        parameters.put("client_id", Oauth2Enum.CLIENT_ID.getEnum());
        parameters.put("client_secret", Oauth2Enum.CLIENT_SECRET.getEnum());
        parameters.put("redirect_uri", "http://baidu.com");
        parameters.put("code", code);
        Map<String, Object> tokenInfo = oauth2Client.postAccessToken(parameters);
        return tokenInfo;
    }



}
