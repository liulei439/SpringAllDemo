package com.learning.multidatasource.mapper;

import com.learning.multidatasource.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface IndexMapper {
    User queryUserInfo(@Param("id") int id);

    User queryUserInfo1(@Param("id") int id);
}
