package com.parking.caculate.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@TableName("cac_charge_log")
public class CacChargeLog implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String logNo;

    private String orderNo;

    private String plateNumber;

    private Long parkingLotId;

    private String parkingLotName;

    private LocalDateTime enterTime;

    private LocalDateTime exitTime;

    private Integer duration;

    private Integer feeSource;

    private BigDecimal originalAmount;

    private BigDecimal discountAmount;

    private BigDecimal finalAmount;

    private Long monthlyCardId;

    private BigDecimal monthlyCardDiscount;

    private Long couponId;

    private BigDecimal couponDiscount;

    private String discountDetails;

    private Long rateRuleId;

    private Long specialRuleId;

    private Integer isSynced;

    private LocalDateTime syncTime;

    private Integer syncStatus;

    private Integer syncRetryCount;

    private Integer cloudVerifyStatus;

    private BigDecimal cloudVerifyAmount;

    private BigDecimal amountDiff;

    private LocalDateTime verifyTime;

    private String remark;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime gmtCreate;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime gmtModified;

    @TableLogic
    private Integer isDeleted;
}