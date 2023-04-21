package com.knowledge.asyn.tx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.knowledge.asyn.tx.entities.SysLog;
import com.knowledge.asyn.tx.mapper.ISysLogMapper;
import com.knowledge.asyn.tx.service.ISysLogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional
public class SysLogService extends ServiceImpl<ISysLogMapper, SysLog> implements ISysLogService {

    @Override
    public boolean addSysLog(String remark) {
        SysLog sysLog = new SysLog().setCreateTime(new Date()).setRemark(remark);
        return this.save(sysLog);
    }
}
