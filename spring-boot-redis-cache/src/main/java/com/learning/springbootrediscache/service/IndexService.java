package com.learning.springbootrediscache.service;


import com.learning.springbootrediscache.entity.User;

public interface IndexService {
    User queryUserInfo(int id);
}
