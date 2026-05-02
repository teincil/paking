package com.parking.common.dto;

import lombok.Data;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ChargeRuleDTO implements Serializable {

    private Long id;
    private Long parkingLotId;
    private String rateName;
    private Integer rateType;
    private BigDecimal firstHourPrice;
    private BigDecimal hourlyPrice;
    private BigDecimal dailyMaxPrice;
    private BigDecimal halfHourPrice;
    private Integer chargeInterval;
    private Integer freeDuration;
    private Integer status;
    private LocalDateTime effectiveStart;
    private LocalDateTime effectiveEnd;
}