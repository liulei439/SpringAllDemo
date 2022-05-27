package com.learning.springbootswagger2.controller;

import com.learning.springbootswagger2.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@Api(tags = "测试swagger接口",description = "User模块")//描述
public class IndexController {
    @ApiOperation(value = "我的第一个swagger接口")
    @PostMapping("/swagger")
    public User testUser(@ApiParam(value = "用户实体", required = true) @RequestBody User user, HttpServletRequest request) {
        System.out.println(request.getHeader("token"));
        return user;
    }
}
