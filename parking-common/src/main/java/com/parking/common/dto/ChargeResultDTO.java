package com.parking.common.dto;

import lombok.Data;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ChargeResultDTO implements Serializable {

    private String orderNo;
    private String plateNumber;
    private Long parkingLotId;
    private LocalDateTime enterTime;
    private LocalDateTime exitTime;
    private Integer duration;
    private BigDecimal originalAmount;
    private BigDecimal discountAmount;
    private BigDecimal finalAmount;
    private Long couponId;
    private String couponName;
    private BigDecimal couponAmount;
    private Integer feeSource;
    private String ruleSignature;
}