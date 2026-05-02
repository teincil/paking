package com.parking.user.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.parking.common.entity.Result;
import com.parking.user.entity.SysBalanceLog;
import com.parking.user.service.SysBalanceLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/balance-log")
public class SysBalanceLogController {

    @Autowired
    private SysBalanceLogService sysBalanceLogService;

    @GetMapping("/{id}")
    public Result<SysBalanceLog> getById(@PathVariable Long id) {
        return Result.success(sysBalanceLogService.getById(id));
    }

    @GetMapping("/page")
    public Result<Page<SysBalanceLog>> page(Page<SysBalanceLog> page) {
        return Result.success(sysBalanceLogService.page(page));
    }

    @PostMapping
    public Result<Boolean> save(@RequestBody SysBalanceLog sysBalanceLog) {
        return Result.success(sysBalanceLogService.save(sysBalanceLog));
    }

    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable Long id) {
        return Result.success(sysBalanceLogService.removeById(id));
    }
}