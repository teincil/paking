package com.parking.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.parking.order.entity.OrderMain;
import com.parking.order.mapper.OrderMainMapper;
import com.parking.order.service.OrderMainService;
import org.springframework.stereotype.Service;

@Service
public class OrderMainServiceImpl extends ServiceImpl<OrderMainMapper, OrderMain> implements OrderMainService {
}