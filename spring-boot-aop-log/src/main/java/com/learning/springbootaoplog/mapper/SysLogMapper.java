package com.learning.springbootaoplog.mapper;

import com.learning.springbootaoplog.entity.SysLog;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysLogMapper {
    int insertSysLog(SysLog sysLog);
}
