package com.learning.springbootrediscache.mapper;

import com.learning.springbootrediscache.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface IndexMapper {
    User queryUserInfo(@Param("id") int id);

    int updateUserInfo(User user);

    int deleteUserInfo(int id);

    int insertUserInfo(User user);
}
