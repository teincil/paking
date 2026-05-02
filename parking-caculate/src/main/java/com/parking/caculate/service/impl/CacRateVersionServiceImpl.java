package com.parking.caculate.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.parking.caculate.entity.CacRateVersion;
import com.parking.caculate.mapper.CacRateVersionMapper;
import com.parking.caculate.service.CacRateVersionService;
import org.springframework.stereotype.Service;

@Service
public class CacRateVersionServiceImpl extends ServiceImpl<CacRateVersionMapper, CacRateVersion> implements CacRateVersionService {
}