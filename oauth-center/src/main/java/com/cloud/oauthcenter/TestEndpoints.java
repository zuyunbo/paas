package com.cloud.oauthcenter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestEndpoints {
  private static final Logger log = LoggerFactory.getLogger(TestEndpoints.class);
  // 添加一个测试访问接口
  @GetMapping("/user")
  public Authentication getUser(Authentication authentication) {
    log.info("resource: user {}", authentication);
    return authentication;
  }


  @GetMapping("/hello")
  public String index(@RequestParam String name) {
    return "hello "+name+"，this is first messge";
  }
}
