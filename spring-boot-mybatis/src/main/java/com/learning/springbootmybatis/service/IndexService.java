package com.learning.springbootmybatis.service;

import com.learning.springbootmybatis.entity.User;

public interface IndexService {
    User queryUserInfo(int id);
}
