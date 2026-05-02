package com.parking.caculate.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@TableName("cac_user_coupon")
public class CacUserCoupon implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String userCouponNo;

    private Long userId;

    private Long couponId;

    private String couponNo;

    private Integer source;

    private LocalDateTime receiveTime;

    private LocalDateTime effectiveStart;

    private LocalDateTime effectiveEnd;

    private LocalDateTime useTime;

    private String orderNo;

    private Integer status;

    private String remark;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime gmtCreate;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime gmtModified;

    @TableLogic
    private Integer isDeleted;
}