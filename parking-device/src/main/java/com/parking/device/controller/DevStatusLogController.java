package com.parking.device.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.parking.common.entity.Result;
import com.parking.device.entity.DevStatusLog;
import com.parking.device.service.DevStatusLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/status-log")
public class DevStatusLogController {

    @Autowired
    private DevStatusLogService devStatusLogService;

    @GetMapping("/{id}")
    public Result<DevStatusLog> getById(@PathVariable Long id) {
        return Result.success(devStatusLogService.getById(id));
    }

    @GetMapping("/page")
    public Result<Page<DevStatusLog>> page(Page<DevStatusLog> page) {
        return Result.success(devStatusLogService.page(page));
    }

    @PostMapping
    public Result<Boolean> save(@RequestBody DevStatusLog devStatusLog) {
        return Result.success(devStatusLogService.save(devStatusLog));
    }

    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable Long id) {
        return Result.success(devStatusLogService.removeById(id));
    }
}