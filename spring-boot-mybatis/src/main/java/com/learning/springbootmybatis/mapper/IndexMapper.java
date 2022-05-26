package com.learning.springbootmybatis.mapper;

import com.learning.springbootmybatis.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface IndexMapper {
    User queryUserInfo(@Param("id") int id);
}
