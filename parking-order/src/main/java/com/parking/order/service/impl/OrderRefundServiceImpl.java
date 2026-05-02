package com.parking.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.parking.order.entity.OrderRefund;
import com.parking.order.mapper.OrderRefundMapper;
import com.parking.order.service.OrderRefundService;
import org.springframework.stereotype.Service;

@Service
public class OrderRefundServiceImpl extends ServiceImpl<OrderRefundMapper, OrderRefund> implements OrderRefundService {
}