package com.parking.user.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.parking.common.entity.Result;
import com.parking.user.entity.SysMonthlyCard;
import com.parking.user.service.SysMonthlyCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/monthly-card")
public class SysMonthlyCardController {

    @Autowired
    private SysMonthlyCardService sysMonthlyCardService;

    @GetMapping("/{id}")
    public Result<SysMonthlyCard> getById(@PathVariable Long id) {
        return Result.success(sysMonthlyCardService.getById(id));
    }

    @GetMapping("/page")
    public Result<Page<SysMonthlyCard>> page(Page<SysMonthlyCard> page) {
        return Result.success(sysMonthlyCardService.page(page));
    }

    @PostMapping
    public Result<Boolean> save(@RequestBody SysMonthlyCard sysMonthlyCard) {
        return Result.success(sysMonthlyCardService.save(sysMonthlyCard));
    }

    @PutMapping
    public Result<Boolean> update(@RequestBody SysMonthlyCard sysMonthlyCard) {
        return Result.success(sysMonthlyCardService.updateById(sysMonthlyCard));
    }

    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable Long id) {
        return Result.success(sysMonthlyCardService.removeById(id));
    }
}