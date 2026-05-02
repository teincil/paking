package com.parking.order.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@TableName("order_main")
public class OrderMain implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String orderNo;

    private String plateNumber;

    private Long parkingLotId;

    private String parkingLotName;

    private LocalDateTime enterTime;

    private LocalDateTime exitTime;

    private BigDecimal originalAmount;

    private BigDecimal discountAmount;

    private Long couponId;

    private BigDecimal couponAmount;

    private BigDecimal finalAmount;

    private String paymentMethod;

    private Integer paymentStatus;

    private Integer orderStatus;

    private Long userId;

    private Long vehicleId;

    private Long monthlyCardId;

    private Integer isMonthlyCard;

    private String enterChannel;

    private String exitChannel;

    private String remark;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime gmtCreate;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime gmtModified;

    @TableLogic
    private Integer isDeleted;
}