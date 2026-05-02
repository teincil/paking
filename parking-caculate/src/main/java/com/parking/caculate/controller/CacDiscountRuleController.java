package com.parking.caculate.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.parking.caculate.entity.CacDiscountRule;
import com.parking.caculate.service.CacDiscountRuleService;
import com.parking.common.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/discount-rule")
public class CacDiscountRuleController {

    @Autowired
    private CacDiscountRuleService cacDiscountRuleService;

    @GetMapping("/{id}")
    public Result<CacDiscountRule> getById(@PathVariable Long id) {
        return Result.success(cacDiscountRuleService.getById(id));
    }

    @GetMapping("/page")
    public Result<Page<CacDiscountRule>> page(Page<CacDiscountRule> page) {
        return Result.success(cacDiscountRuleService.page(page));
    }

    @PostMapping
    public Result<Boolean> save(@RequestBody CacDiscountRule entity) {
        return Result.success(cacDiscountRuleService.save(entity));
    }

    @PutMapping
    public Result<Boolean> update(@RequestBody CacDiscountRule entity) {
        return Result.success(cacDiscountRuleService.updateById(entity));
    }

    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable Long id) {
        return Result.success(cacDiscountRuleService.removeById(id));
    }
}