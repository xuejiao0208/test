package com.example.demo.service;

import com.example.demo.entity.Manager;
import com.example.demo.entity.Nav;

import java.util.Collection;

public interface NavService {

    Nav getNavByNavid(String navid);

    Collection<Nav> getAll();

    void save(Nav nav);

    public void update(Nav nav) ;

    Nav get(String id);

    Integer countByNavid(String navid);

    boolean delete(String id);
}
