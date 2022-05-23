package com.learning.springbootaoplog.controller;

import com.learning.springbootaoplog.entity.User;
import com.learning.springbootaoplog.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @Autowired
    private IndexService indexService;

    @GetMapping("/index/{id}")
    public User index(@PathVariable("id") int id){
        return indexService.getUserInfo(id);
    }

}
