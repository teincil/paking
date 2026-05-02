package com.parking.device.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.parking.device.entity.DevChannel;
import com.parking.device.mapper.DevChannelMapper;
import com.parking.device.service.DevChannelService;
import org.springframework.stereotype.Service;

@Service
public class DevChannelServiceImpl extends ServiceImpl<DevChannelMapper, DevChannel> implements DevChannelService {
}