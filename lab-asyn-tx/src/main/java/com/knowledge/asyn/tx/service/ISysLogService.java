package com.knowledge.asyn.tx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.knowledge.asyn.tx.entities.SysLog;

public interface ISysLogService extends IService<SysLog> {

    boolean addSysLog(String remark);
}
