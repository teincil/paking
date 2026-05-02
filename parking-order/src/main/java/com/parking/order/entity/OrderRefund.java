package com.parking.order.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@TableName("order_refund")
public class OrderRefund implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String refundNo;

    private String orderNo;

    private Long orderId;

    private Long userId;

    private Integer refundType;

    private BigDecimal refundAmount;

    private BigDecimal refundBalance;

    private BigDecimal refundGift;

    private String refundReason;

    private String refundEvidence;

    private String refundAccount;

    private String transactionNo;

    private Integer status;

    private String channelResponse;

    private Long operateId;

    private String operateName;

    private LocalDateTime processTime;

    private LocalDateTime completeTime;

    private String remark;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime gmtCreate;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime gmtModified;

    @TableLogic
    private Integer isDeleted;
}