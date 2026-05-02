package com.parking.caculate.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.parking.caculate.entity.CacChargeLog;
import com.parking.caculate.mapper.CacChargeLogMapper;
import com.parking.caculate.service.CacChargeLogService;
import org.springframework.stereotype.Service;

@Service
public class CacChargeLogServiceImpl extends ServiceImpl<CacChargeLogMapper, CacChargeLog> implements CacChargeLogService {
}