package com.parking.device.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.parking.common.entity.Result;
import com.parking.device.entity.DevChannel;
import com.parking.device.service.DevChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/channel")
public class DevChannelController {

    @Autowired
    private DevChannelService devChannelService;

    @GetMapping("/{id}")
    public Result<DevChannel> getById(@PathVariable Long id) {
        return Result.success(devChannelService.getById(id));
    }

    @GetMapping("/page")
    public Result<Page<DevChannel>> page(Page<DevChannel> page) {
        return Result.success(devChannelService.page(page));
    }

    @PostMapping
    public Result<Boolean> save(@RequestBody DevChannel devChannel) {
        return Result.success(devChannelService.save(devChannel));
    }

    @PutMapping
    public Result<Boolean> update(@RequestBody DevChannel devChannel) {
        return Result.success(devChannelService.updateById(devChannel));
    }

    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable Long id) {
        return Result.success(devChannelService.removeById(id));
    }
}