package com.parking.device.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@TableName("dev_pass_record")
public class DevPassRecord implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String recordNo;

    private String plateNumber;

    private String plateColor;

    private Long parkingLotId;

    private String parkingLotName;

    private Long channelId;

    private String channelName;

    private Integer channelType;

    private Long cameraId;

    private Long gateId;

    private Long sensorId;

    private LocalDateTime passTime;

    private Integer passType;

    private String plateNumberOrig;

    private Integer isAiRecognize;

    private BigDecimal recognizeConfidence;

    private String captureImage;

    private String captureImage2;

    private Integer isMatched;

    private String matchOrderNo;

    private Long orderId;

    private Long userId;

    private Long vehicleId;

    private Long monthlyCardId;

    private Integer gateAction;

    private LocalDateTime gateActionTime;

    private Integer exceptionType;

    private String exceptionDesc;

    private Long operatorId;

    private String operatorName;

    private String remark;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime gmtCreate;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime gmtModified;

    @TableLogic
    private Integer isDeleted;
}