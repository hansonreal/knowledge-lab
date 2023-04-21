package com.knowledge.asyn.tx.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Accessors(chain = true)
@TableName("SYS_LOG")
public class SysLog implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId(value = "LOG_ID", type = IdType.INPUT)
    private Long logId;

    @TableField("REMARK")
    private String remark;

    @TableField("create_time")
    private Date createTime;
}
