package com.parking.device.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.parking.device.entity.DevPassRecord;
import com.parking.device.mapper.DevPassRecordMapper;
import com.parking.device.service.DevPassRecordService;
import org.springframework.stereotype.Service;

@Service
public class DevPassRecordServiceImpl extends ServiceImpl<DevPassRecordMapper, DevPassRecord> implements DevPassRecordService {
}