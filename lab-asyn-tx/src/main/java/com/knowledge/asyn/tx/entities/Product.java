package com.knowledge.asyn.tx.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Accessors(chain = true)
@TableName("PRODUCT")
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "pid", type = IdType.INPUT)
    private Long pid;

    @TableField("pro_name")
    private String proName;

    @TableField("create_time")
    private Date createTime;
}
