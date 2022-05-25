package com.learning.springbootjackson.service.impl;

import com.learning.springbootjackson.entity.User;
import com.learning.springbootjackson.mapper.IndexMapper;
import com.learning.springbootjackson.service.IndexService;
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
}
