package com.parking.device.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@TableName("dev_parking_lot")
public class DevParkingLot implements Serializable {

    @TableId(type = IdType.AUTO)
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

    private String logo;

    private String contactPhone;

    private String remark;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime gmtCreate;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime gmtModified;

    @TableLogic
    private Integer isDeleted;
}