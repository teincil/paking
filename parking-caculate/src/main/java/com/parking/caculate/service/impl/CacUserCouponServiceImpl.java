package com.parking.caculate.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.parking.caculate.entity.CacUserCoupon;
import com.parking.caculate.mapper.CacUserCouponMapper;
import com.parking.caculate.service.CacUserCouponService;
import org.springframework.stereotype.Service;

@Service
public class CacUserCouponServiceImpl extends ServiceImpl<CacUserCouponMapper, CacUserCoupon> implements CacUserCouponService {
}