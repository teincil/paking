package com.parking.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.parking.user.entity.SysVehicle;
import com.parking.user.mapper.SysVehicleMapper;
import com.parking.user.service.SysVehicleService;
import org.springframework.stereotype.Service;

@Service
public class SysVehicleServiceImpl extends ServiceImpl<SysVehicleMapper, SysVehicle> implements SysVehicleService {
}