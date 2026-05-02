package com.parking.common.dto;

import lombok.Data;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class CouponDTO implements Serializable {

    private Long id;
    private String couponNo;
    private String couponName;
    private Integer couponType;
    private BigDecimal thresholdAmount;
    private BigDecimal discountValue;
    private Integer discountMode;
    private Integer freeDuration;
    private Integer validDays;
    private LocalDateTime effectiveStart;
    private LocalDateTime effectiveEnd;
    private String parkingLotIds;
    private Integer status;
}