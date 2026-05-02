package com.parking.caculate.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.parking.caculate.entity.CacCoupon;
import com.parking.caculate.mapper.CacCouponMapper;
import com.parking.caculate.service.CacCouponService;
import org.springframework.stereotype.Service;

@Service
public class CacCouponServiceImpl extends ServiceImpl<CacCouponMapper, CacCoupon> implements CacCouponService {
}