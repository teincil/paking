package com.parking.common.dto;

import lombok.Data;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class UserDTO implements Serializable {

    private Long id;
    private String nickname;
    private String avatar;
    private String mobile;
    private BigDecimal balance;
    private BigDecimal giftBalance;
    private Integer vipLevel;
    private Integer status;
}