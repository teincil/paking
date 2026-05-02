package com.parking.order.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.parking.common.entity.Result;
import com.parking.order.entity.OrderRefund;
import com.parking.order.service.OrderRefundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order-refund")
public class OrderRefundController {

    @Autowired
    private OrderRefundService orderRefundService;

    @GetMapping("/{id}")
    public Result<OrderRefund> getById(@PathVariable Long id) {
        return Result.success(orderRefundService.getById(id));
    }

    @GetMapping("/page")
    public Result<Page<OrderRefund>> page(Page<OrderRefund> page) {
        return Result.success(orderRefundService.page(page));
    }

    @PostMapping
    public Result<Boolean> save(@RequestBody OrderRefund orderRefund) {
        return Result.success(orderRefundService.save(orderRefund));
    }

    @PutMapping
    public Result<Boolean> update(@RequestBody OrderRefund orderRefund) {
        return Result.success(orderRefundService.updateById(orderRefund));
    }

    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable Long id) {
        return Result.success(orderRefundService.removeById(id));
    }
}