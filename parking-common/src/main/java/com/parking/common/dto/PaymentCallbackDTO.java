package com.parking.common.dto;

import lombok.Data;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PaymentCallbackDTO implements Serializable {

    private String orderNo;
    private String transactionNo;
    private String paymentMethod;
    private BigDecimal amount;
    private Integer status;
    private String channelResponse;
    private LocalDateTime payTime;
}