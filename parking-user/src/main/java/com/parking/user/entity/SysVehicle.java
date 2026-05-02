package com.parking.user.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@TableName("sys_vehicle")
public class SysVehicle implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long id;

    private Long userId;

    private String plateNumber;

    private String plateColor;

    private String vehicleColor;

    private String brand;

    private String model;

    private Integer isNewEnergy;

    private Integer isDefault;

    private Integer status;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime gmtCreate;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime gmtModified;

    @TableLogic
    private Integer isDeleted;
}