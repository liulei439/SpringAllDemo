package com.learning.authentication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.learning.authentication.mapper")
public class SpringSecurityAuthenticationApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityAuthenticationApplication.class, args);
    }

}
