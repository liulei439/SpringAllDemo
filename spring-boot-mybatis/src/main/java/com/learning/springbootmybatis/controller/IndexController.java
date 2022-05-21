package com.learning.springbootmybatis.controller;

import com.learning.springbootmybatis.entity.User;
import com.learning.springbootmybatis.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    @Autowired
    private IndexService indexService;

    @GetMapping("/getInfo/{id}")
    public User getInfo(@PathVariable("id") int id){
        return indexService.queryUserInfo(id);
    }
}
