package com.parking.user.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.parking.common.entity.Result;
import com.parking.user.entity.SysVehicle;
import com.parking.user.service.SysVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vehicle")
public class SysVehicleController {

    @Autowired
    private SysVehicleService sysVehicleService;

    @GetMapping("/{id}")
    public Result<SysVehicle> getById(@PathVariable Long id) {
        return Result.success(sysVehicleService.getById(id));
    }

    @GetMapping("/page")
    public Result<Page<SysVehicle>> page(Page<SysVehicle> page) {
        return Result.success(sysVehicleService.page(page));
    }

    @PostMapping
    public Result<Boolean> save(@RequestBody SysVehicle sysVehicle) {
        return Result.success(sysVehicleService.save(sysVehicle));
    }

    @PutMapping
    public Result<Boolean> update(@RequestBody SysVehicle sysVehicle) {
        return Result.success(sysVehicleService.updateById(sysVehicle));
    }

    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable Long id) {
        return Result.success(sysVehicleService.removeById(id));
    }
}