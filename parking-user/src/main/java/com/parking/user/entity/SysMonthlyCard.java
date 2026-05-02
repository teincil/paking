package com.parking.user.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@TableName("sys_monthly_card")
public class SysMonthlyCard implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long id;

    private Long userId;

    private Long vehicleId;

    private String cardNo;

    private Integer type;

    private Long parkingLotId;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private BigDecimal price;

    private Integer freeDuration;

    private Integer status;

    private LocalDateTime refundTime;

    private BigDecimal refundAmount;

    private String remark;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime gmtCreate;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime gmtModified;

    @TableLogic
    private Integer isDeleted;
}