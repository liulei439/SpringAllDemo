package com.learning.mybatispage.mapper;

import com.learning.mybatispage.entity.User;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

@Component
public interface UserMapper1 extends Mapper<User>, MySqlMapper<User> {
}
