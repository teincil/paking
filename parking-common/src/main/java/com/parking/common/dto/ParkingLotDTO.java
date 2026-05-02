package com.parking.common.dto;

import lombok.Data;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class ParkingLotDTO implements Serializable {

    private Long id;
    private String lotCode;
    private String lotName;
    private Integer lotType;
    private String province;
    private String city;
    private String district;
    private String address;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private Integer totalSpace;
    private Integer freeSpace;
    private BigDecimal hourlyRate;
    private BigDecimal maxDailyRate;
    private Integer freeDuration;
    private String openingHours;
    private Integer is24h;
    private Integer status;
    private String contactPhone;
}