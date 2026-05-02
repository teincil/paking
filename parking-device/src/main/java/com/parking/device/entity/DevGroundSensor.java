package com.parking.device.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@TableName("dev_ground_sensor")
public class DevGroundSensor implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long id;

    private Long parkingLotId;

    private Long channelId;

    private String sensorCode;

    private String sensorName;

    private Integer sensorType;

    private String brand;

    private String model;

    private String ipAddress;

    private Integer port;

    private Integer sensitivity;

    private Integer detectDistance;

    private Integer vehicleDetectStatus;

    private Integer onlineStatus;

    private LocalDateTime lastHeartbeat;

    private Integer isEnabled;

    private Integer sort;

    private String remark;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime gmtCreate;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime gmtModified;

    @TableLogic
    private Integer isDeleted;
}