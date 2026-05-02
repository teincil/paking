package com.parking.common.dto;

import lombok.Data;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class OrderCalcDTO implements Serializable {

    private String orderNo;
    private String plateNumber;
    private Long parkingLotId;
    private Long userId;
    private Long couponId;
}