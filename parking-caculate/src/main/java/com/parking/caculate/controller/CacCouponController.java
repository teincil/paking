package com.parking.caculate.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.parking.caculate.entity.CacCoupon;
import com.parking.caculate.service.CacCouponService;
import com.parking.common.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/coupon")
public class CacCouponController {

    @Autowired
    private CacCouponService cacCouponService;

    @GetMapping("/{id}")
    public Result<CacCoupon> getById(@PathVariable Long id) {
        return Result.success(cacCouponService.getById(id));
    }

    @GetMapping("/page")
    public Result<Page<CacCoupon>> page(Page<CacCoupon> page) {
        return Result.success(cacCouponService.page(page));
    }

    @PostMapping
    public Result<Boolean> save(@RequestBody CacCoupon entity) {
        return Result.success(cacCouponService.save(entity));
    }

    @PutMapping
    public Result<Boolean> update(@RequestBody CacCoupon entity) {
        return Result.success(cacCouponService.updateById(entity));
    }

    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable Long id) {
        return Result.success(cacCouponService.removeById(id));
    }
}