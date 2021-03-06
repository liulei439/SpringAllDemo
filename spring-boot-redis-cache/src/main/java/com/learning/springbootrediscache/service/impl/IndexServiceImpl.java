package com.learning.springbootrediscache.service.impl;

import com.learning.springbootrediscache.entity.User;
import com.learning.springbootrediscache.mapper.IndexMapper;
import com.learning.springbootrediscache.service.IndexService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class IndexServiceImpl implements IndexService {
    @Resource
    private IndexMapper indexMapper;
    @Override
    public User queryUserInfo(int id) {
        return indexMapper.queryUserInfo(id);
    }

    @Override
    public User updateUserInfo(User user) {
        int i = indexMapper.updateUserInfo(user);
        if (i==0){
            return null;
        }
        return user;
    }

    @Override
    public int deleteUserInfo(int id) {
        return indexMapper.deleteUserInfo(id);
    }

    @Override
    public int insertUserInfo(User user) {
        return indexMapper.insertUserInfo(user);
    }
}
