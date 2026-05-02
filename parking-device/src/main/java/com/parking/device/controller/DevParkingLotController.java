package com.parking.device.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.parking.common.entity.Result;
import com.parking.device.entity.DevParkingLot;
import com.parking.device.service.DevParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/parking-lot")
public class DevParkingLotController {

    @Autowired
    private DevParkingLotService devParkingLotService;

    @GetMapping("/{id}")
    public Result<DevParkingLot> getById(@PathVariable Long id) {
        return Result.success(devParkingLotService.getById(id));
    }

    @GetMapping("/page")
    public Result<Page<DevParkingLot>> page(Page<DevParkingLot> page) {
        return Result.success(devParkingLotService.page(page));
    }

    @PostMapping
    public Result<Boolean> save(@RequestBody DevParkingLot devParkingLot) {
        return Result.success(devParkingLotService.save(devParkingLot));
    }

    @PutMapping
    public Result<Boolean> update(@RequestBody DevParkingLot devParkingLot) {
        return Result.success(devParkingLotService.updateById(devParkingLot));
    }

    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable Long id) {
        return Result.success(devParkingLotService.removeById(id));
    }
}