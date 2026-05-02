package com.parking.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.parking.user.entity.SysBlacklist;
import com.parking.user.mapper.SysBlacklistMapper;
import com.parking.user.service.SysBlacklistService;
import org.springframework.stereotype.Service;

@Service
public class SysBlacklistServiceImpl extends ServiceImpl<SysBlacklistMapper, SysBlacklist> implements SysBlacklistService {
}