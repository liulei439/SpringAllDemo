package com.learning.multidatasource.service.impl;

import com.learning.multidatasource.annotation.DataSource;
import com.learning.multidatasource.datasource.DataSourceNames;
import com.learning.multidatasource.entity.User;
import com.learning.multidatasource.mapper.IndexMapper;
import com.learning.multidatasource.service.IndexService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class IndexServiceImpl implements IndexService {

    @Resource
    private IndexMapper indexMapper;

    @Override
    @DataSource(name = DataSourceNames.MASTER)
    public User getUserInfo(int id) {
        return indexMapper.queryUserInfo(id);
    }

    @Override
    @DataSource(name = DataSourceNames.SLAVE)
    public User getUserInfo1(int id) {
        User user = indexMapper.queryUserInfo1(id);
        System.out.println(user);
        return user;
    }
}
