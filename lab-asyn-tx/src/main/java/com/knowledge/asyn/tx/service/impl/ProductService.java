package com.knowledge.asyn.tx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.knowledge.asyn.tx.entities.Product;
import com.knowledge.asyn.tx.mapper.IProductMapper;
import com.knowledge.asyn.tx.service.IProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional
public class ProductService extends ServiceImpl<IProductMapper, Product> implements IProductService {

    @Override
    public boolean saveProduct(String proName) {
        Product product = new Product().setCreateTime(new Date()).setProName(proName);
        return this.save(product);
    }
}
