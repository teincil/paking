package com.parking.caculate.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.parking.caculate.entity.CacSpecialRule;
import com.parking.caculate.service.CacSpecialRuleService;
import com.parking.common.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/special-rule")
public class CacSpecialRuleController {

    @Autowired
    private CacSpecialRuleService cacSpecialRuleService;

    @GetMapping("/{id}")
    public Result<CacSpecialRule> getById(@PathVariable Long id) {
        return Result.success(cacSpecialRuleService.getById(id));
    }

    @GetMapping("/page")
    public Result<Page<CacSpecialRule>> page(Page<CacSpecialRule> page) {
        return Result.success(cacSpecialRuleService.page(page));
    }

    @PostMapping
    public Result<Boolean> save(@RequestBody CacSpecialRule entity) {
        return Result.success(cacSpecialRuleService.save(entity));
    }

    @PutMapping
    public Result<Boolean> update(@RequestBody CacSpecialRule entity) {
        return Result.success(cacSpecialRuleService.updateById(entity));
    }

    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable Long id) {
        return Result.success(cacSpecialRuleService.removeById(id));
    }
}