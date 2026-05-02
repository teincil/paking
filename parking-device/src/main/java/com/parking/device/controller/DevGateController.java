package com.parking.device.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.parking.common.entity.Result;
import com.parking.device.entity.DevGate;
import com.parking.device.service.DevGateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/gate")
public class DevGateController {

    @Autowired
    private DevGateService devGateService;

    @GetMapping("/{id}")
    public Result<DevGate> getById(@PathVariable Long id) {
        return Result.success(devGateService.getById(id));
    }

    @GetMapping("/page")
    public Result<Page<DevGate>> page(Page<DevGate> page) {
        return Result.success(devGateService.page(page));
    }

    @PostMapping
    public Result<Boolean> save(@RequestBody DevGate devGate) {
        return Result.success(devGateService.save(devGate));
    }

    @PutMapping
    public Result<Boolean> update(@RequestBody DevGate devGate) {
        return Result.success(devGateService.updateById(devGate));
    }

    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable Long id) {
        return Result.success(devGateService.removeById(id));
    }
}