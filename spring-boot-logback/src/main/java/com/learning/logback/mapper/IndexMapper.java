package com.learning.logback.mapper;


import com.learning.logback.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface IndexMapper {
    User queryUserInfo(@Param("id") int id);
}
