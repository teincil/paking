package com.parking.device.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.parking.common.entity.Result;
import com.parking.device.entity.DevCamera;
import com.parking.device.service.DevCameraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/camera")
public class DevCameraController {

    @Autowired
    private DevCameraService devCameraService;

    @GetMapping("/{id}")
    public Result<DevCamera> getById(@PathVariable Long id) {
        return Result.success(devCameraService.getById(id));
    }

    @GetMapping("/page")
    public Result<Page<DevCamera>> page(Page<DevCamera> page) {
        return Result.success(devCameraService.page(page));
    }

    @PostMapping
    public Result<Boolean> save(@RequestBody DevCamera devCamera) {
        return Result.success(devCameraService.save(devCamera));
    }

    @PutMapping
    public Result<Boolean> update(@RequestBody DevCamera devCamera) {
        return Result.success(devCameraService.updateById(devCamera));
    }

    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable Long id) {
        return Result.success(devCameraService.removeById(id));
    }
}