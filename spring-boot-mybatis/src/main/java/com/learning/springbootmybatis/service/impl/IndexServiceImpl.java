package com.learning.springbootmybatis.service.impl;

import com.learning.springbootmybatis.entity.User;
import com.learning.springbootmybatis.mapper.IndexMapper;
import com.learning.springbootmybatis.service.IndexService;
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
