package com.parking.caculate.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.parking.caculate.entity.CacLotRate;
import com.parking.caculate.mapper.CacLotRateMapper;
import com.parking.caculate.service.CacLotRateService;
import org.springframework.stereotype.Service;

@Service
public class CacLotRateServiceImpl extends ServiceImpl<CacLotRateMapper, CacLotRate> implements CacLotRateService {
}