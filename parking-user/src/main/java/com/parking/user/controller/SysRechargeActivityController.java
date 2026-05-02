package com.parking.user.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.parking.common.entity.Result;
import com.parking.user.entity.SysRechargeActivity;
import com.parking.user.service.SysRechargeActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/recharge-activity")
public class SysRechargeActivityController {

    @Autowired
    private SysRechargeActivityService sysRechargeActivityService;

    @GetMapping("/{id}")
    public Result<SysRechargeActivity> getById(@PathVariable Long id) {
        return Result.success(sysRechargeActivityService.getById(id));
    }

    @GetMapping("/page")
    public Result<Page<SysRechargeActivity>> page(Page<SysRechargeActivity> page) {
        return Result.success(sysRechargeActivityService.page(page));
    }

    @PostMapping
    public Result<Boolean> save(@RequestBody SysRechargeActivity sysRechargeActivity) {
        return Result.success(sysRechargeActivityService.save(sysRechargeActivity));
    }

    @PutMapping
    public Result<Boolean> update(@RequestBody SysRechargeActivity sysRechargeActivity) {
        return Result.success(sysRechargeActivityService.updateById(sysRechargeActivity));
    }

    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable Long id) {
        return Result.success(sysRechargeActivityService.removeById(id));
    }
}