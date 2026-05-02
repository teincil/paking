package com.parking.caculate.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.parking.caculate.entity.CacRateVersion;
import com.parking.caculate.service.CacRateVersionService;
import com.parking.common.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rate-version")
public class CacRateVersionController {

    @Autowired
    private CacRateVersionService cacRateVersionService;

    @GetMapping("/{id}")
    public Result<CacRateVersion> getById(@PathVariable Long id) {
        return Result.success(cacRateVersionService.getById(id));
    }

    @GetMapping("/page")
    public Result<Page<CacRateVersion>> page(Page<CacRateVersion> page) {
        return Result.success(cacRateVersionService.page(page));
    }

    @PostMapping
    public Result<Boolean> save(@RequestBody CacRateVersion entity) {
        return Result.success(cacRateVersionService.save(entity));
    }

    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable Long id) {
        return Result.success(cacRateVersionService.removeById(id));
    }
}