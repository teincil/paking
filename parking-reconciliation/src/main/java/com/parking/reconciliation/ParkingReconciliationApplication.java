package com.parking.reconciliation;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableDiscoveryClient
public class ParkingReconciliationApplication {

    public static void main(String[] args) {
        SpringApplication.run(ParkingReconciliationApplication.class, args);
    }
}