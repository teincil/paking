package com.parking.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.parking.user.entity.SysMonthlyCard;
import com.parking.user.mapper.SysMonthlyCardMapper;
import com.parking.user.service.SysMonthlyCardService;
import org.springframework.stereotype.Service;

@Service
public class SysMonthlyCardServiceImpl extends ServiceImpl<SysMonthlyCardMapper, SysMonthlyCard> implements SysMonthlyCardService {
}