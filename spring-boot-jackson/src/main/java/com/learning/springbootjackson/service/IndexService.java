package com.learning.springbootjackson.service;


import com.learning.springbootjackson.entity.User;

public interface IndexService {
    User queryUserInfo(int id);
}
