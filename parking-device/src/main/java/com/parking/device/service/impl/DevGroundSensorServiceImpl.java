package com.parking.device.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.parking.device.entity.DevGroundSensor;
import com.parking.device.mapper.DevGroundSensorMapper;
import com.parking.device.service.DevGroundSensorService;
import org.springframework.stereotype.Service;

@Service
public class DevGroundSensorServiceImpl extends ServiceImpl<DevGroundSensorMapper, DevGroundSensor> implements DevGroundSensorService {
}