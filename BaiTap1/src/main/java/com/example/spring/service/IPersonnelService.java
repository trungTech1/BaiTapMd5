package com.example.spring.service;

import com.example.spring.model.Personnel;

import java.util.List;

public interface IPersonnelService {
    List<Personnel> findAll();

    Personnel findById(Integer id);

    void save(Personnel customers);

    void delete(Integer id);
}
