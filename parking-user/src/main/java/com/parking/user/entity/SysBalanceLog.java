package com.parking.user.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@TableName("sys_balance_log")
public class SysBalanceLog implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long id;

    private Long userId;

    private String orderNo;

    private Integer type;

    private Integer changeType;

    private BigDecimal beforeBalance;

    private BigDecimal changeBalance;

    private BigDecimal afterBalance;

    private BigDecimal beforeGiftBalance;

    private BigDecimal changeGiftBalance;

    private BigDecimal afterGiftBalance;

    private String paymentChannel;

    private Long activityId;

    private String remark;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime gmtCreate;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime gmtModified;

    @TableLogic
    private Integer isDeleted;
}