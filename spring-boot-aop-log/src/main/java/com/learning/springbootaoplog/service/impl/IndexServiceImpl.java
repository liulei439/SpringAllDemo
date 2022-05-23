package com.learning.springbootaoplog.service.impl;

import com.learning.springbootaoplog.annotation.Log;
import com.learning.springbootaoplog.entity.User;
import com.learning.springbootaoplog.mapper.IndexMapper;
import com.learning.springbootaoplog.service.IndexService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class IndexServiceImpl implements IndexService {

    @Resource
    private IndexMapper indexMapper;

    @Override
    @Log(operateType = "1")
    public User getUserInfo(int id) {
        return indexMapper.queryUserInfo(id);
    }

}
