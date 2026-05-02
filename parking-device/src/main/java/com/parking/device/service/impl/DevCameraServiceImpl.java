package com.parking.device.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.parking.device.entity.DevCamera;
import com.parking.device.mapper.DevCameraMapper;
import com.parking.device.service.DevCameraService;
import org.springframework.stereotype.Service;

@Service
public class DevCameraServiceImpl extends ServiceImpl<DevCameraMapper, DevCamera> implements DevCameraService {
}