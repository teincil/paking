package com.parking.device.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@TableName("dev_status_log")
public class DevStatusLog implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long id;

    private Integer deviceType;

    private Long deviceId;

    private String deviceCode;

    private Long parkingLotId;

    private String beforeStatus;

    private String afterStatus;

    private Integer changeType;

    private Integer alarmLevel;

    private String alarmMessage;

    private String alarmData;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime gmtCreate;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime gmtModified;

    @TableLogic
    private Integer isDeleted;
}