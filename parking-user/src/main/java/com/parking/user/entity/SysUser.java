package com.parking.user.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@TableName("sys_user")
public class SysUser implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String nickname;

    private String avatar;

    private String mobile;

    private String wechatOpenid;

    private String alipayOpenid;

    private BigDecimal balance;

    private BigDecimal giftBalance;

    private BigDecimal totalRecharge;

    private BigDecimal totalConsume;

    private Integer vipLevel;

    private Integer status;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime gmtCreate;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime gmtModified;

    @TableLogic
    private Integer isDeleted;
}