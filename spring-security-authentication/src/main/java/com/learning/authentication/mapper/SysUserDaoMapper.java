package com.learning.authentication.mapper;


import com.learning.authentication.entity.SysUser;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface SysUserDaoMapper extends Mapper<SysUser>, MySqlMapper<SysUser> {
}