package com.parking.device.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.parking.device.entity.DevParkingLot;
import com.parking.device.mapper.DevParkingLotMapper;
import com.parking.device.service.DevParkingLotService;
import org.springframework.stereotype.Service;

@Service
public class DevParkingLotServiceImpl extends ServiceImpl<DevParkingLotMapper, DevParkingLot> implements DevParkingLotService {
}