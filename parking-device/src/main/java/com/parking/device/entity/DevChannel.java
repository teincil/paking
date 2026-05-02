package com.parking.device.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@TableName("dev_channel")
public class DevChannel implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long id;

    private Long parkingLotId;

    private String channelCode;

    private String channelName;

    private Integer channelType;

    private Long gateId;

    private Long cameraId;

    private Long auxCameraId;

    private Long sensorId;

    private Integer sort;

    private Integer status;

    private String remark;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime gmtCreate;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime gmtModified;

    @TableLogic
    private Integer isDeleted;
}