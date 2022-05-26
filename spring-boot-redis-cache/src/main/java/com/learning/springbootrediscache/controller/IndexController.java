package com.learning.springbootrediscache.controller;

import com.learning.springbootrediscache.entity.User;
import com.learning.springbootrediscache.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class IndexController {
    @Autowired
    private IndexService indexService;

    @GetMapping("/getInfo/{id}")
    public User getInfo(@PathVariable("id") int id){
        return indexService.queryUserInfo(id);
    }

    @PostMapping("/updateUserInfo")
    public User updateUserInfo(@RequestBody User user){
         return indexService.updateUserInfo(user);
    }

    @GetMapping("/deleteUserInfo/{id}")
    public int deleteUserInfo(@PathVariable("id") int id){
        return indexService.deleteUserInfo(id);
    }

    @PostMapping("/insetUserInfo")
    public int insertUserInfo(@RequestBody User user){
        return indexService.insertUserInfo(user);
    }
}