package com.learning.mybatispage;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.learning.mybatispage.entity.User;
import com.learning.mybatispage.mapper.UserMapper1;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@SpringBootTest
@Slf4j
class SpringBootMybatispageApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private UserMapper1 userMapper1;
    /**
     * 测试通用Mapper - 保存
     */
    @Test
    public void testInsert(){
        User user = new User();
        user.setId(new Random().nextInt());
        user.setUsername("lei");
        user.setAge(18);
        user.setAddress("湖南");
        user.setBirthday(new Date());
        userMapper1.insert(user);
        System.out.println(user.getId());
    }

    /**
     * 测试通用Mapper - 批量保存
     */
    @Test
    public void testInsertList() {
        List<User> userList = Lists.newArrayList();
        for (int i = 4; i < 14; i++) {
            User user = new User();
            user.setId(new Random().nextInt());
            user.setUsername("lei");
            user.setAge(18);
            user.setAddress("湖南");
            user.setBirthday(new Date());
            userList.add(user);
        }
        userMapper1.insertList(userList);
        List<Integer> ids = userList.stream().map(User::getId).collect(Collectors.toList());
        log.debug("【测试主键回写#userList.ids】= {}", ids);
    }

    /**
     * 测试通用Mapper - 删除
     */
    @Test
    public void testDelete() {
        int primaryKey = -1531371737;
        userMapper1.deleteByPrimaryKey(primaryKey);
    }

    /**
     * 测试通用Mapper - 更新
     */
    @Test
    public void testUpdate() {
        int primaryKey = -939056475;
        User user = userMapper1.selectByPrimaryKey(primaryKey);
        user.setUsername("通用Mapper名字更新");
        userMapper1.updateByPrimaryKeySelective(user);
        User update = userMapper1.selectByPrimaryKey(primaryKey);
        log.debug("【update】= {}", update);
    }

    /**
     * 测试通用Mapper - 查询单个
     */
    @Test
    public void testQueryOne(){
        User user = userMapper1.selectByPrimaryKey(-939056475);
        log.debug("【user】= {}", user);
    }

    /**
     * 测试通用Mapper - 查询全部
     */
    @Test
    public void testQueryAll() {
        List<User> users = userMapper1.selectAll();
        log.debug("【users】= {}", users);
    }

    /**
     * 测试分页助手 - 分页排序查询
     */
    @Test
    public void testQueryByPageAndSort() {
        int currentPage = 1;
        int pageSize = 5;
        String orderBy = "id desc";
        int count = userMapper1.selectCount(null);
        PageHelper.startPage(currentPage, pageSize, orderBy);
        List<User> users = userMapper1.selectAll();
        PageInfo<User> userPageInfo = new PageInfo<>(users);
        log.debug("【userPageInfo】= {}", userPageInfo);
        System.out.println(count);
        System.out.println(users.size());
    }

    /**
     * 测试通用Mapper - 条件查询
     */
    @Test
    public void testQueryByCondition() {
        Example example = new Example(User.class);
        // 过滤
        example.createCriteria().andLike("username", "%le%").andEqualTo("address", "湖南");
        // 排序
        example.setOrderByClause("id desc");
        int count = userMapper1.selectCountByExample(example);
        // 分页
        PageHelper.startPage(1, 3);
        // 查询
        List<User> userList = userMapper1.selectByExample(example);
        PageInfo<User> userPageInfo = new PageInfo<>(userList);
        log.debug("【userPageInfo】= {}", userPageInfo);
        System.out.println(count);
    }

}
