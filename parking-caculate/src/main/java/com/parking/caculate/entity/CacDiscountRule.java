package com.parking.caculate.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@TableName("cac_discount_rule")
public class CacDiscountRule implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long id;

    private Long parkingLotId;

    private String ruleName;

    private Integer discountType;

    private Integer vipLevel;

    private BigDecimal discountValue;

    private Integer discountMode;

    private String startTime;

    private String endTime;

    private String dayOfWeek;

    private Integer minParkingDuration;

    private BigDecimal maxDiscountAmount;

    private Integer status;

    private LocalDateTime effectiveStart;

    private LocalDateTime effectiveEnd;

    private Integer sort;

    private String remark;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime gmtCreate;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime gmtModified;

    @TableLogic
    private Integer isDeleted;
}