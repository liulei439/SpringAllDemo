package com.learning.xssprevent.controller;

import net.dreamlu.mica.xss.core.XssCleanIgnore;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@XssCleanIgnore // 设置该注解 用于跳过配置的Xss 防护 这是第一种方式最简单
public class IndexController {
    @RequestMapping("/xss")
    //data使用用例  <font color="red">红色</font>
    public String index(String data){
        return data;
    }
}
