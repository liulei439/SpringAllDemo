package com.learning.springbootaoplog.mapper;

import com.learning.springbootaoplog.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface IndexMapper {
    User queryUserInfo(@Param("id") int id);

}
