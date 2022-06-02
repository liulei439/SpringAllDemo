package com.learning.authentication;

import com.learning.authentication.entity.SysUser;
import com.learning.authentication.mapper.SysUserDaoMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class SpringSecurityAuthenticationApplicationTests {

    @Test
    void contextLoads() {
    }

    @Resource
    private SysUserDaoMapper mapper;

    @Test
    public void testMapper(){
        List<SysUser> sysUsers = mapper.selectAll();
        sysUsers.forEach(System.out::println);
    }

    @Test
    public void testUserMapper(){
        Example example = new Example(SysUser.class);
        example.createCriteria().andEqualTo("userName","ll");
        SysUser user = mapper.selectOneByExample(example);
        System.out.println(user);
    }
}
