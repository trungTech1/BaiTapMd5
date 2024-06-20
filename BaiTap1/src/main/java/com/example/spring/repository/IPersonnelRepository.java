package com.example.spring.repository;

import com.example.spring.model.Personnel;

import java.util.List;

public interface IPersonnelRepository {
    List<Personnel> findAll();

    Personnel findById(Integer id);

    void save(Personnel customers);

    void delete(Integer id);

}
