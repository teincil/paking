package com.parking.common.dto;

import lombok.Data;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class VehicleDTO implements Serializable {

    private Long id;
    private Long userId;
    private String plateNumber;
    private String plateColor;
    private String vehicleColor;
    private String brand;
    private String model;
    private Integer isNewEnergy;
    private Integer isDefault;
}