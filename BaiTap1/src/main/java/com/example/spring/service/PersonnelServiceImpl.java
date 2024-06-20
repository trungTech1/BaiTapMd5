package com.example.spring.service;

import com.example.spring.model.Personnel;
import com.example.spring.repository.IPersonnelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PersonnelServiceImpl implements IPersonnelService{
    @Autowired
    private IPersonnelRepository customerRepository;

    @Override
    public List<Personnel> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Personnel findById(Integer id) {
        return customerRepository.findById(id);
    }

    @Override
    public void save(Personnel customers) {
        customers.setStatus(true);
        customerRepository.save(customers);
    }

    @Override
    public void delete(Integer id) {
        customerRepository.delete(id);
    }
}
