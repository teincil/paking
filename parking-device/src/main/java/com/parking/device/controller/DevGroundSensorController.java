package com.parking.device.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.parking.common.entity.Result;
import com.parking.device.entity.DevGroundSensor;
import com.parking.device.service.DevGroundSensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ground-sensor")
public class DevGroundSensorController {

    @Autowired
    private DevGroundSensorService devGroundSensorService;

    @GetMapping("/{id}")
    public Result<DevGroundSensor> getById(@PathVariable Long id) {
        return Result.success(devGroundSensorService.getById(id));
    }

    @GetMapping("/page")
    public Result<Page<DevGroundSensor>> page(Page<DevGroundSensor> page) {
        return Result.success(devGroundSensorService.page(page));
    }

    @PostMapping
    public Result<Boolean> save(@RequestBody DevGroundSensor devGroundSensor) {
        return Result.success(devGroundSensorService.save(devGroundSensor));
    }

    @PutMapping
    public Result<Boolean> update(@RequestBody DevGroundSensor devGroundSensor) {
        return Result.success(devGroundSensorService.updateById(devGroundSensor));
    }

    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable Long id) {
        return Result.success(devGroundSensorService.removeById(id));
    }
}