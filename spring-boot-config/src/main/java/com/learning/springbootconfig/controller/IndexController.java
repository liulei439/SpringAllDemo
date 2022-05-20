package com.learning.springbootconfig.controller;

import com.learning.springbootconfig.config.ConfigBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class IndexController {

//    @Value("${learning.blog.name}")
//    public String name;
//    @Value("${learning.blog.title}")
//    public String title;
//    @Value("${learning.blog.wholeTitle}")
//    public String wholeTitle;

    @Resource
    private ConfigBean configBean;

    @GetMapping("/index")
    public String index(){
        System.out.println(4444);
        return configBean.getName()+"----"+configBean.getTitle();
    }

    @GetMapping("/test")
    public String index1(){
        System.out.println(3333);
        return configBean.getWholeTitle();
    }
}
