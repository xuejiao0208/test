package com.example.demo.service.impl;

import com.example.demo.entity.Manager;
import com.example.demo.mapper.ManagerMapper;
import com.example.demo.service.ManagerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ManagerServiceImpl implements ManagerService {
    @Resource
    private ManagerMapper managerMapper;
    @Override
    public Manager getManagerByUsername(String username) {
        return managerMapper.getManagerByUsername(username);
    }
}
