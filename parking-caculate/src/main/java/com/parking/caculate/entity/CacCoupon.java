package com.parking.caculate.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@TableName("cac_coupon")
public class CacCoupon implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String couponNo;

    private String couponName;

    private Integer couponType;

    private BigDecimal thresholdAmount;

    private BigDecimal discountValue;

    private Integer discountMode;

    private Integer freeDuration;

    private Integer totalCount;

    private Integer usedCount;

    private Integer perUserLimit;

    private Integer validDays;

    private LocalDateTime effectiveStart;

    private LocalDateTime effectiveEnd;

    private String parkingLotIds;

    private Integer status;

    private Integer issueType;

    private Integer sort;

    private String remark;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime gmtCreate;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime gmtModified;

    @TableLogic
    private Integer isDeleted;
}