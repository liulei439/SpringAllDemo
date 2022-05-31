package com.learning.logback.service;


import com.learning.logback.entity.User;

public interface IndexService {
    User queryUserInfo(int id);
}
