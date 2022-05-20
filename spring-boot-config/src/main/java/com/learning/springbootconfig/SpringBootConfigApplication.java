package com.learning.springbootconfig;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootConfigApplication {

    public static void main(String[] args) {
//        SpringApplication.run(SpringBootConfigApplication.class, args);
        SpringApplication app = new SpringApplication(SpringBootConfigApplication.class);
        app.setBannerMode(Banner.Mode.OFF); //关闭banner.txt
        app.run(args);
    }

}
