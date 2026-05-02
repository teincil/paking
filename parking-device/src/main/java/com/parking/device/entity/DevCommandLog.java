package com.parking.device.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@TableName("dev_command_log")
public class DevCommandLog implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String commandNo;

    private Integer deviceType;

    private Long deviceId;

    private String deviceCode;

    private Long parkingLotId;

    private Integer commandType;

    private String commandParams;

    private Integer commandStatus;

    private LocalDateTime sendTime;

    private LocalDateTime executeTime;

    private String executeResult;

    private String responseData;

    private Integer retryCount;

    private Integer maxRetry;

    private Long orderId;

    private Long passRecordId;

    private Long operatorId;

    private String operatorName;

    private Integer operatorType;

    private String remark;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime gmtCreate;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime gmtModified;

    @TableLogic
    private Integer isDeleted;
}