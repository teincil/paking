package com.parking.common.dto;

import lombok.Data;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class OrderCreateDTO implements Serializable {

    private String plateNumber;
    private Long parkingLotId;
    private String parkingLotName;
    private LocalDateTime enterTime;
    private String enterChannel;
    private Long userId;
    private Long vehicleId;
    private Long monthlyCardId;
    private Integer isMonthlyCard;
}