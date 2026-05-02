package com.parking.common.dto;

import lombok.Data;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PaymentDTO implements Serializable {

    private String orderNo;
    private BigDecimal amount;
    private String paymentMethod;
    private String plateNumber;
    private Long userId;
}