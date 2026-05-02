package com.parking.caculate.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.parking.caculate.entity.CacRateRule;
import com.parking.caculate.mapper.CacRateRuleMapper;
import com.parking.caculate.service.CacRateRuleService;
import org.springframework.stereotype.Service;

@Service
public class CacRateRuleServiceImpl extends ServiceImpl<CacRateRuleMapper, CacRateRule> implements CacRateRuleService {
}