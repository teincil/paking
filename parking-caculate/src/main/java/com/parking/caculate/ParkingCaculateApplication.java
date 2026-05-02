package com.parking.caculate;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableDiscoveryClient
public class ParkingCaculateApplication {

    public static void main(String[] args) {
        SpringApplication.run(ParkingCaculateApplication.class, args);
    }
}