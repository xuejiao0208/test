package com.example.demo.service;

import com.example.demo.entity.Manager;

public interface ManagerService {
    Manager getManagerByUsername(String username);
}
