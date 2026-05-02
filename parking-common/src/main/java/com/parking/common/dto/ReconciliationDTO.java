package com.parking.common.dto;

import lombok.Data;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ReconciliationDTO implements Serializable {

    private String date;
    private Long parkingLotId;
    private String parkingLotName;
    private Integer totalOrders;
    private Integer paidOrders;
    private Integer unpaidOrders;
    private BigDecimal totalAmount;
    private BigDecimal paidAmount;
    private BigDecimal unpaidAmount;
    private Integer exceptionCount;
    private String status;
}