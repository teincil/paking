package com.parking.order.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.parking.common.entity.Result;
import com.parking.order.entity.OrderMain;
import com.parking.order.service.OrderMainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
public class OrderMainController {

    @Autowired
    private OrderMainService orderMainService;

    @GetMapping("/{id}")
    public Result<OrderMain> getById(@PathVariable Long id) {
        return Result.success(orderMainService.getById(id));
    }

    @GetMapping("/orderNo/{orderNo}")
    public Result<OrderMain> getByOrderNo(@PathVariable String orderNo) {
        return Result.success(orderMainService.lambdaQuery()
                .eq(OrderMain::getOrderNo, orderNo).one());
    }

    @GetMapping("/page")
    public Result<Page<OrderMain>> page(Page<OrderMain> page) {
        return Result.success(orderMainService.page(page));
    }

    @PostMapping
    public Result<Boolean> save(@RequestBody OrderMain orderMain) {
        return Result.success(orderMainService.save(orderMain));
    }

    @PutMapping
    public Result<Boolean> update(@RequestBody OrderMain orderMain) {
        return Result.success(orderMainService.updateById(orderMain));
    }

    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable Long id) {
        return Result.success(orderMainService.removeById(id));
    }
}