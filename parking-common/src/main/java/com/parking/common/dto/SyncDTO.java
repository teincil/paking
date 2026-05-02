package com.parking.common.dto;

import lombok.Data;
import java.io.Serializable;

@Data
public class SyncDTO implements Serializable {

    private String deviceCode;
    private Integer dataType;
    private Long lastSyncTime;
    private String syncStatus;
}