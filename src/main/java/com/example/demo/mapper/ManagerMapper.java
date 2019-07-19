package com.example.demo.mapper;


import com.example.demo.entity.Manager;
import org.springframework.stereotype.Component;

import java.util.Collection;


@Component
public interface ManagerMapper {

    Manager getManagerByUsername(String username);

    Collection<Manager> getAll();

    void save(Manager manager);

    void update(Manager manager);

    Manager getManagerByUserid(String id);

    Integer countByUsername(String managerName);

    boolean delete(String id);
}