package com.parking.user.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@TableName("sys_recharge_activity")
public class SysRechargeActivity implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String name;

    private String description;

    private BigDecimal rechargeAmount;

    private BigDecimal giftAmount;

    private BigDecimal minRecharge;

    private Integer totalLimit;

    private Integer dailyLimit;

    private Integer soldCount;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private Integer status;

    private Integer sort;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime gmtCreate;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime gmtModified;

    @TableLogic
    private Integer isDeleted;
}