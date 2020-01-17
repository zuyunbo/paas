package com.cloud.oauthcenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@EnableResourceServer
@SpringBootApplication
public class OauthCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(OauthCenterApplication.class, args);
    }

}
