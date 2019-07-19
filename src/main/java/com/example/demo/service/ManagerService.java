package com.example.demo.service;

import com.example.demo.entity.Manager;

import java.util.Collection;

public interface ManagerService {
    Manager getManagerByUsername(String username);

    Collection<Manager> getAll();

    void save(Manager employee);

    public void update(Manager manager) ;

    Manager get(String id);

    Integer countByUsername(String managerName);

    boolean delete(String id);
}
