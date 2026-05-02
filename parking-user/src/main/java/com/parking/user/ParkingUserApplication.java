package com.parking.user;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableDiscoveryClient
public class ParkingUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(ParkingUserApplication.class, args);
    }
}