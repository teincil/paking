package com.parking.common.dto;

import lombok.Data;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class OrderDTO implements Serializable {

    private Long id;
    private String orderNo;
    private String plateNumber;
    private Long parkingLotId;
    private String parkingLotName;
    private LocalDateTime enterTime;
    private LocalDateTime exitTime;
    private BigDecimal originalAmount;
    private BigDecimal discountAmount;
    private BigDecimal couponAmount;
    private BigDecimal finalAmount;
    private String paymentMethod;
    private Integer paymentStatus;
    private Integer orderStatus;
    private Long userId;
    private Integer isMonthlyCard;
    private String enterChannel;
    private String exitChannel;
}