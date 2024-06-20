package com.example.baitap3.service;


import com.example.baitap3.model.Accounts;

import java.util.List;

public interface IAccountService {
    List<Accounts> findAll();

    Accounts findById(Integer id);

    void save(Accounts accounts);

    void delete(Integer id);
}
