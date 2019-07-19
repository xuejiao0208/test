package com.example.demo.service.impl;

import com.example.demo.entity.Manager;
import com.example.demo.mapper.ManagerMapper;
import com.example.demo.service.ManagerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;

@Service
public class ManagerServiceImpl implements ManagerService {
    @Resource
    private ManagerMapper managerMapper;
    @Override
    public Manager getManagerByUsername(String username) {
        return managerMapper.getManagerByUsername(username);
    }

    @Override
    public Collection<Manager> getAll() {
        return managerMapper.getAll();
    }

    @Override
    public void save(Manager manager) {

            managerMapper.save(manager);

    }

    @Override
    public void update(Manager manager) {

        managerMapper.update(manager);

    }

    @Override
    public Manager get(String id) {
        return managerMapper.getManagerByUserid(id);
    }

    @Override
    public Integer countByUsername(String managerName) {
        return managerMapper.countByUsername(managerName);
    }

    @Override
    public boolean delete(String id) {
        return managerMapper.delete(id);
    }


}
