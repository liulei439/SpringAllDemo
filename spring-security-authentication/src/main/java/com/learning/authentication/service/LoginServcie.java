package com.learning.authentication.service;

import com.learning.authentication.entity.SysUser;
import com.learning.authentication.entity.response.ResponseResult;

public interface LoginServcie {
    ResponseResult login(SysUser user);
}
