package com.parking.user.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.parking.common.entity.Result;
import com.parking.user.entity.SysUser;
import com.parking.user.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @GetMapping("/{id}")
    public Result<SysUser> getById(@PathVariable Long id) {
        return Result.success(sysUserService.getById(id));
    }

    @GetMapping("/page")
    public Result<Page<SysUser>> page(Page<SysUser> page) {
        return Result.success(sysUserService.page(page));
    }

    @PostMapping
    public Result<Boolean> save(@RequestBody SysUser sysUser) {
        return Result.success(sysUserService.save(sysUser));
    }

    @PutMapping
    public Result<Boolean> update(@RequestBody SysUser sysUser) {
        return Result.success(sysUserService.updateById(sysUser));
    }

    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable Long id) {
        return Result.success(sysUserService.removeById(id));
    }
}