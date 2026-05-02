package com.parking.order;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableDiscoveryClient
public class ParkingOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ParkingOrderApplication.class, args);
    }
}