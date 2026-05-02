package com.parking.caculate.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.parking.caculate.entity.CacUserCoupon;
import com.parking.caculate.service.CacUserCouponService;
import com.parking.common.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user-coupon")
public class CacUserCouponController {

    @Autowired
    private CacUserCouponService cacUserCouponService;

    @GetMapping("/{id}")
    public Result<CacUserCoupon> getById(@PathVariable Long id) {
        return Result.success(cacUserCouponService.getById(id));
    }

    @GetMapping("/page")
    public Result<Page<CacUserCoupon>> page(Page<CacUserCoupon> page) {
        return Result.success(cacUserCouponService.page(page));
    }

    @PostMapping
    public Result<Boolean> save(@RequestBody CacUserCoupon entity) {
        return Result.success(cacUserCouponService.save(entity));
    }

    @PutMapping
    public Result<Boolean> update(@RequestBody CacUserCoupon entity) {
        return Result.success(cacUserCouponService.updateById(entity));
    }

    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable Long id) {
        return Result.success(cacUserCouponService.removeById(id));
    }
}