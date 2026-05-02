package com.parking.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.parking.user.entity.SysBalanceLog;
import com.parking.user.mapper.SysBalanceLogMapper;
import com.parking.user.service.SysBalanceLogService;
import org.springframework.stereotype.Service;

@Service
public class SysBalanceLogServiceImpl extends ServiceImpl<SysBalanceLogMapper, SysBalanceLog> implements SysBalanceLogService {
}