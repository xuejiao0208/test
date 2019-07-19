package com.example.demo.mapper;

import com.example.demo.entity.Nav;
import org.springframework.stereotype.Component;

import java.util.Collection;


@Component
public interface NavMapper {

    Nav getNavByNavid(String navid);

    Collection<Nav> getAll();

    void save(Nav nav);

    void update(Nav nav);

    Nav get(String id);

    Integer countByNavid(String navid);

    boolean delete(String id);
}