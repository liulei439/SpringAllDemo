package com.learning.logback.service.impl;

import com.learning.logback.entity.User;
import com.learning.logback.mapper.IndexMapper;
import com.learning.logback.service.IndexService;
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
