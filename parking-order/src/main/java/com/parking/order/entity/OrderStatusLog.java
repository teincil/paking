package com.parking.order.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@TableName("order_status_log")
public class OrderStatusLog implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String orderNo;

    private Long orderId;

    private Integer operationType;

    private Integer beforeStatus;

    private Integer afterStatus;

    private Integer beforePaymentStatus;

    private Integer afterPaymentStatus;

    private BigDecimal beforeAmount;

    private BigDecimal afterAmount;

    private BigDecimal changeAmount;

    private Long couponId;

    private String couponName;

    private String remark;

    private Long operatorId;

    private String operatorName;

    private Integer operatorType;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime gmtCreate;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime gmtModified;

    @TableLogic
    private Integer isDeleted;
}