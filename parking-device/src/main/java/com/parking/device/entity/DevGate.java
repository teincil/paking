package com.parking.device.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@TableName("dev_gate")
public class DevGate implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long id;

    private Long parkingLotId;

    private String gateCode;

    private String gateName;

    private String gateType;

    private String brand;

    private String model;

    private String ipAddress;

    private Integer port;

    private Integer baudRate;

    private String protocol;

    private Integer gateStatus;

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