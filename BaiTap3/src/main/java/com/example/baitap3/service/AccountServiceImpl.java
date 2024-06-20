package com.example.baitap3.service;


import com.example.baitap3.model.Accounts;
import com.example.baitap3.repository.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements IAccountService {
    @Autowired
    private IAccountRepository customerRepository;

    @Override
    public List<Accounts> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Accounts findById(Integer id) {
        return customerRepository.findById(id);
    }

    @Override
    public void save(Accounts accounts) {
        customerRepository.save(accounts);
    }

    @Override
    public void delete(Integer id) {
        customerRepository.delete(id);
    }
}
