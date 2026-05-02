package com.parking.caculate.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@TableName("cac_rate_rule")
public class CacRateRule implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long id;

    private Long lotRateId;

    private Integer ruleType;

    private String ruleName;

    private Integer startDuration;

    private Integer endDuration;

    private BigDecimal price;

    private Integer priceType;

    private Integer stepIndex;

    private Integer sort;

    private Integer status;

    private String remark;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime gmtCreate;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime gmtModified;

    @TableLogic
    private Integer isDeleted;
}