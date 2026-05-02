package com.parking.device.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.parking.device.entity.DevGate;
import com.parking.device.mapper.DevGateMapper;
import com.parking.device.service.DevGateService;
import org.springframework.stereotype.Service;

@Service
public class DevGateServiceImpl extends ServiceImpl<DevGateMapper, DevGate> implements DevGateService {
}