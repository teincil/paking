package com.parking.device.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.parking.common.entity.Result;
import com.parking.device.entity.DevPassRecord;
import com.parking.device.service.DevPassRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pass-record")
public class DevPassRecordController {

    @Autowired
    private DevPassRecordService devPassRecordService;

    @GetMapping("/{id}")
    public Result<DevPassRecord> getById(@PathVariable Long id) {
        return Result.success(devPassRecordService.getById(id));
    }

    @GetMapping("/page")
    public Result<Page<DevPassRecord>> page(Page<DevPassRecord> page) {
        return Result.success(devPassRecordService.page(page));
    }

    @PostMapping
    public Result<Boolean> save(@RequestBody DevPassRecord devPassRecord) {
        return Result.success(devPassRecordService.save(devPassRecord));
    }

    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable Long id) {
        return Result.success(devPassRecordService.removeById(id));
    }
}