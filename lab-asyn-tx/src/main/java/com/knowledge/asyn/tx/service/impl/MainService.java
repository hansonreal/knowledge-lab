package com.knowledge.asyn.tx.service.impl;

import com.knowledge.asyn.tx.service.IMainService;
import com.knowledge.asyn.tx.service.IProductService;
import com.knowledge.asyn.tx.service.ISysLogService;
import org.springframework.stereotype.Service;

@Service
public class MainService implements IMainService {

    private IProductService productService;

    private ISysLogService sysLogService;



}
