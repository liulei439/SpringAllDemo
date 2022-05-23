package com.learning.multidatasource.controller;

import com.learning.multidatasource.entity.User;
import com.learning.multidatasource.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class IndexController {

    @Autowired
    private IndexService indexService;

    @GetMapping("/index/{id}")
    public User index(@PathVariable("id") int id){
        return indexService.getUserInfo(id);
    }

    @GetMapping("/index1/{id}")
    public User index1(@PathVariable("id") int id){
        return indexService.getUserInfo1(id);
    }
}
