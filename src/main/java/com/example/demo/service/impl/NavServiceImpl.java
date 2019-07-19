package com.example.demo.service.impl;

import com.example.demo.entity.Nav;
import com.example.demo.mapper.NavMapper;
import com.example.demo.service.NavService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.UUID;

@Service
public class NavServiceImpl implements NavService {

    @Resource
    private NavMapper navMapper;

    @Override
    public Nav getNavByNavid(String navid) {
        return navMapper.getNavByNavid(navid);
    }

    @Override
    public Collection<Nav> getAll() {
        return navMapper.getAll();
    }

    @Override
    public void save(Nav nav) {
        String navid = UUID.randomUUID().toString();
        nav.setNavId(navid);
        navMapper.save(nav);
    }

    @Override
    public void update(Nav nav) {
        navMapper.update(nav);
    }

    @Override
    public Nav get(String id) {
        return navMapper.get(id);
    }

    @Override
    public Integer countByNavid(String navid) {
        return navMapper.countByNavid(navid);
    }

    @Override
    public boolean delete(String id) {
        return navMapper.delete(id);
    }
}
