package com.parking.caculate.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.parking.caculate.entity.CacRateRule;
import com.parking.caculate.service.CacRateRuleService;
import com.parking.common.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rate-rule")
public class CacRateRuleController {

    @Autowired
    private CacRateRuleService cacRateRuleService;

    @GetMapping("/{id}")
    public Result<CacRateRule> getById(@PathVariable Long id) {
        return Result.success(cacRateRuleService.getById(id));
    }

    @GetMapping("/page")
    public Result<Page<CacRateRule>> page(Page<CacRateRule> page) {
        return Result.success(cacRateRuleService.page(page));
    }

    @PostMapping
    public Result<Boolean> save(@RequestBody CacRateRule entity) {
        return Result.success(cacRateRuleService.save(entity));
    }

    @PutMapping
    public Result<Boolean> update(@RequestBody CacRateRule entity) {
        return Result.success(cacRateRuleService.updateById(entity));
    }

    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable Long id) {
        return Result.success(cacRateRuleService.removeById(id));
    }
}