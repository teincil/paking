package com.parking.user.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@TableName("sys_blacklist")
public class SysBlacklist implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long id;

    private Long userId;

    private String plateNumber;

    private String reason;

    private String evidence;

    private Integer source;

    private Long orderId;

    private Long operateId;

    private String operateName;

    private Integer status;

    private String unblockReason;

    private LocalDateTime unblockTime;

    private Long unblockOperateId;

    private String unblockOperateName;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime gmtCreate;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime gmtModified;

    @TableLogic
    private Integer isDeleted;
}