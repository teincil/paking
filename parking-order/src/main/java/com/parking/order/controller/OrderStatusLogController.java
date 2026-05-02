package com.parking.order.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.parking.common.entity.Result;
import com.parking.order.entity.OrderStatusLog;
import com.parking.order.service.OrderStatusLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order-status-log")
public class OrderStatusLogController {

    @Autowired
    private OrderStatusLogService orderStatusLogService;

    @GetMapping("/{id}")
    public Result<OrderStatusLog> getById(@PathVariable Long id) {
        return Result.success(orderStatusLogService.getById(id));
    }

    @GetMapping("/page")
    public Result<Page<OrderStatusLog>> page(Page<OrderStatusLog> page) {
        return Result.success(orderStatusLogService.page(page));
    }

    @PostMapping
    public Result<Boolean> save(@RequestBody OrderStatusLog orderStatusLog) {
        return Result.success(orderStatusLogService.save(orderStatusLog));
    }

    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable Long id) {
        return Result.success(orderStatusLogService.removeById(id));
    }
}