package com.learning.globalexception.controller;

import com.learning.globalexception.commonEnum.AppHttpCodeEnum;
import com.learning.globalexception.entity.ResponseResult;
import com.learning.globalexception.exception.SystemException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    @RequestMapping("/index")
    public ResponseResult index(){
        throw  new SystemException(AppHttpCodeEnum.SYSTEM_ERROR);
    }
}
