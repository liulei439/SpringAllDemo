package com.learning.springbootmybatis;

import com.learning.springbootmybatis.entity.User;
import com.learning.springbootmybatis.mapper.IndexMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class SpringBootMybatisApplicationTests {

    @Test
    void contextLoads() {
    }

    @Resource
    private IndexMapper indexMapper;
    @Test
    public void testMapper(){
        User user = indexMapper.queryUserInfo(2);
        System.out.println(user);
    }

}
