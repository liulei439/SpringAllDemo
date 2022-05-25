package com.learning.springbootjackson.mapper;

import com.learning.springbootjackson.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface IndexMapper {
    User queryUserInfo(@Param("id") int id);
}
