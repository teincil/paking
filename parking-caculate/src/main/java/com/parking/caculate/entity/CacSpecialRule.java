package com.parking.caculate.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@TableName("cac_special_rule")
public class CacSpecialRule implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long id;

    private Long parkingLotId;

    private String ruleName;

    private Integer specialType;

    private String datePattern;

    private String dayOfWeek;

    private BigDecimal firstHourPrice;

    private BigDecimal hourlyPrice;

    private BigDecimal dailyMaxPrice;

    private Integer freeDuration;

    private Integer status;

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