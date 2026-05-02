package com.parking.device.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.parking.common.entity.Result;
import com.parking.device.entity.DevCommandLog;
import com.parking.device.service.DevCommandLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/command-log")
public class DevCommandLogController {

    @Autowired
    private DevCommandLogService devCommandLogService;

    @GetMapping("/{id}")
    public Result<DevCommandLog> getById(@PathVariable Long id) {
        return Result.success(devCommandLogService.getById(id));
    }

    @GetMapping("/page")
    public Result<Page<DevCommandLog>> page(Page<DevCommandLog> page) {
        return Result.success(devCommandLogService.page(page));
    }

    @PostMapping
    public Result<Boolean> save(@RequestBody DevCommandLog devCommandLog) {
        return Result.success(devCommandLogService.save(devCommandLog));
    }

    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable Long id) {
        return Result.success(devCommandLogService.removeById(id));
    }
}