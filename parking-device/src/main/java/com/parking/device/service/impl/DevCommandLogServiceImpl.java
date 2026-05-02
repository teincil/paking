package com.parking.device.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.parking.device.entity.DevCommandLog;
import com.parking.device.mapper.DevCommandLogMapper;
import com.parking.device.service.DevCommandLogService;
import org.springframework.stereotype.Service;

@Service
public class DevCommandLogServiceImpl extends ServiceImpl<DevCommandLogMapper, DevCommandLog> implements DevCommandLogService {
}