package com.learning.springbootrediscache.mapper;

import com.learning.springbootrediscache.entity.User;
import org.apache.ibatis.annotations.Param;

public interface IndexMapper {
    User queryUserInfo(@Param("id") int id);
}
