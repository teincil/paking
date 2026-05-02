package com.parking.caculate.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.parking.caculate.entity.CacLotRate;
import com.parking.caculate.service.CacLotRateService;
import com.parking.common.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/lot-rate")
public class CacLotRateController {

    @Autowired
    private CacLotRateService cacLotRateService;

    @GetMapping("/{id}")
    public Result<CacLotRate> getById(@PathVariable Long id) {
        return Result.success(cacLotRateService.getById(id));
    }

    @GetMapping("/page")
    public Result<Page<CacLotRate>> page(Page<CacLotRate> page) {
        return Result.success(cacLotRateService.page(page));
    }

    @PostMapping
    public Result<Boolean> save(@RequestBody CacLotRate entity) {
        return Result.success(cacLotRateService.save(entity));
    }

    @PutMapping
    public Result<Boolean> update(@RequestBody CacLotRate entity) {
        return Result.success(cacLotRateService.updateById(entity));
    }

    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable Long id) {
        return Result.success(cacLotRateService.removeById(id));
    }
}