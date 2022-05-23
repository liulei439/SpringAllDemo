package com.learning.springbootaoplog.service.impl;

import com.learning.springbootaoplog.annotation.Log;
import com.learning.springbootaoplog.entity.SysLog;
import com.learning.springbootaoplog.mapper.SysLogMapper;
import com.learning.springbootaoplog.service.SysLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SysLogServiceImpl implements SysLogService {
    @Resource
    private SysLogMapper sysLogMapper;

    @Override
    public void saveSysLog(SysLog syslog) {
        sysLogMapper.insertSysLog(syslog);
    }
}
