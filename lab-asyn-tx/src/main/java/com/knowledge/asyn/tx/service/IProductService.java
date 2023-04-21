package com.knowledge.asyn.tx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.knowledge.asyn.tx.entities.Product;

public interface IProductService extends IService<Product> {
    boolean saveProduct(String proName);
}
