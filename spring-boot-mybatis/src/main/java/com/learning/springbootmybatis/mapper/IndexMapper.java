package com.learning.springbootmybatis.mapper;

import com.learning.springbootmybatis.entity.User;
import org.apache.ibatis.annotations.Param;

public interface IndexMapper {
    User queryUserInfo(@Param("id") int id);
}
