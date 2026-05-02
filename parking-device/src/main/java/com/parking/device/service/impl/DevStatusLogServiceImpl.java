package com.parking.device.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.parking.device.entity.DevStatusLog;
import com.parking.device.mapper.DevStatusLogMapper;
import com.parking.device.service.DevStatusLogService;
import org.springframework.stereotype.Service;

@Service
public class DevStatusLogServiceImpl extends ServiceImpl<DevStatusLogMapper, DevStatusLog> implements DevStatusLogService {
}