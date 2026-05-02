package com.parking.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.parking.order.entity.OrderStatusLog;
import com.parking.order.mapper.OrderStatusLogMapper;
import com.parking.order.service.OrderStatusLogService;
import org.springframework.stereotype.Service;

@Service
public class OrderStatusLogServiceImpl extends ServiceImpl<OrderStatusLogMapper, OrderStatusLog> implements OrderStatusLogService {
}