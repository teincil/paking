package com.parking.common.dto;

import lombok.Data;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ReconciliationDetailDTO implements Serializable {

    private String orderNo;
    private String plateNumber;
    private LocalDateTime enterTime;
    private LocalDateTime exitTime;
    private BigDecimal orderAmount;
    private BigDecimal payAmount;
    private BigDecimal diffAmount;
    private Integer diffType;
    private String remark;
}