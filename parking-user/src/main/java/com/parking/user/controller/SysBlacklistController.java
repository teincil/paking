package com.parking.user.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.parking.common.entity.Result;
import com.parking.user.entity.SysBlacklist;
import com.parking.user.service.SysBlacklistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/blacklist")
public class SysBlacklistController {

    @Autowired
    private SysBlacklistService sysBlacklistService;

    @GetMapping("/{id}")
    public Result<SysBlacklist> getById(@PathVariable Long id) {
        return Result.success(sysBlacklistService.getById(id));
    }

    @GetMapping("/page")
    public Result<Page<SysBlacklist>> page(Page<SysBlacklist> page) {
        return Result.success(sysBlacklistService.page(page));
    }

    @PostMapping
    public Result<Boolean> save(@RequestBody SysBlacklist sysBlacklist) {
        return Result.success(sysBlacklistService.save(sysBlacklist));
    }

    @PutMapping
    public Result<Boolean> update(@RequestBody SysBlacklist sysBlacklist) {
        return Result.success(sysBlacklistService.updateById(sysBlacklist));
    }

    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable Long id) {
        return Result.success(sysBlacklistService.removeById(id));
    }
}