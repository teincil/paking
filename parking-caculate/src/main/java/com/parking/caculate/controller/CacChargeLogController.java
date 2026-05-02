package com.parking.caculate.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.parking.caculate.entity.CacChargeLog;
import com.parking.caculate.service.CacChargeLogService;
import com.parking.common.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/charge-log")
public class CacChargeLogController {

    @Autowired
    private CacChargeLogService cacChargeLogService;

    @GetMapping("/{id}")
    public Result<CacChargeLog> getById(@PathVariable Long id) {
        return Result.success(cacChargeLogService.getById(id));
    }

    @GetMapping("/page")
    public Result<Page<CacChargeLog>> page(Page<CacChargeLog> page) {
        return Result.success(cacChargeLogService.page(page));
    }

    @PostMapping
    public Result<Boolean> save(@RequestBody CacChargeLog entity) {
        return Result.success(cacChargeLogService.save(entity));
    }

    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable Long id) {
        return Result.success(cacChargeLogService.removeById(id));
    }
}