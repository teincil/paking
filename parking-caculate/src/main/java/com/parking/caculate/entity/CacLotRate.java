package com.parking.caculate.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@TableName("cac_lot_rate")
public class CacLotRate implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long id;

    private Long parkingLotId;

    private String parkingLotName;

    private String rateName;

    private Integer rateType;

    private BigDecimal firstHourPrice;

    private BigDecimal hourlyPrice;

    private BigDecimal dailyMaxPrice;

    private BigDecimal halfHourPrice;

    private Integer chargeInterval;

    private Integer freeDuration;

    private Integer maxFreeTimes;

    private Integer status;

    private Integer isDefault;

    private LocalDateTime effectiveStart;

    private LocalDateTime effectiveEnd;

    private String remark;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime gmtCreate;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime gmtModified;

    @TableLogic
    private Integer isDeleted;
}