package com.parking.device;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableDiscoveryClient
public class ParkingDeviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ParkingDeviceApplication.class, args);
    }
}