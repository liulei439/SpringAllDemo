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
}
