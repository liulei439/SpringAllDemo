package com.learning.authentication.controller;

import com.learning.authentication.entity.SysUser;
import com.learning.authentication.entity.response.ResponseResult;
import com.learning.authentication.service.LoginServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private LoginServcie loginServcie;

    @PostMapping("/user/login")
    public ResponseResult login(@RequestBody SysUser user){
        return loginServcie.login(user);
    }

    @PostMapping("/user/getInfo")
    public ResponseResult getInfo(){
        return new ResponseResult(200,"success");
    }
}
