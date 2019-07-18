package com.example.demo.mapper;


import com.example.demo.entity.Manager;
import org.springframework.stereotype.Component;


@Component
public interface ManagerMapper {

    Manager getManagerByUsername(String username);
}