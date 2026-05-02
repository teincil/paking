package com.parking.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableDiscoveryClient
public class ParkingPaymentApplication {

    public static void main(String[] args) {
        SpringApplication.run(ParkingPaymentApplication.class, args);
    }
}