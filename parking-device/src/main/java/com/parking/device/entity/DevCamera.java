package com.parking.device.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@TableName("dev_camera")
public class DevCamera implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long id;

    private Long parkingLotId;

    private Long channelId;

    private String cameraCode;

    private String cameraName;

    private Integer cameraType;

    private String brand;

    private String model;

    private String ipAddress;

    private Integer port;

    private String username;

    private String password;

    private String rtspUrl;

    private String snapshotUrl;

    private Integer aiEnabled;

    private String aiModel;

    private BigDecimal recognizeAccuracy;

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