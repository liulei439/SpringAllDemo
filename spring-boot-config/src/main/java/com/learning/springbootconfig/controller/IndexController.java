package com.learning.springbootconfig.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@ConfigurationProperties(prefix="learning.blog")
public class IndexController {

    @Value("${learning.blog.name}")
    public String name;
    @Value("${learning.blog.title}")
    public String title;
    @Value("${learning.blog.wholeTitle}")
    public String wholeTitle;

    @GetMapping("/index")
    public String index(){
        System.out.println(1111);
        return name+"----"+title;
    }

    @GetMapping("/test")
    public String index1(){
        System.out.println(1111);
        return wholeTitle+"";
    }
}
