package com.parking.common.dto;

import lombok.Data;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PassRecordDTO implements Serializable {

    private String recordNo;
    private String plateNumber;
    private String plateColor;
    private Long parkingLotId;
    private String parkingLotName;
    private Long channelId;
    private String channelName;
    private Integer channelType;
    private LocalDateTime passTime;
    private Integer passType;
    private String captureImage;
    private Integer isMatched;
    private String matchOrderNo;
    private Long userId;
    private Long monthlyCardId;
    private Integer exceptionType;
    private String exceptionDesc;
}