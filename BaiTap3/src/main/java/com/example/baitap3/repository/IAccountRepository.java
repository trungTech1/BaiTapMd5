package com.example.baitap3.repository;



import com.example.baitap3.model.Accounts;

import java.util.List;

public interface IAccountRepository {
    List<Accounts> findAll();

    Accounts findById(Integer id);

    void save(Accounts accounts);

    void delete(Integer id);
}
