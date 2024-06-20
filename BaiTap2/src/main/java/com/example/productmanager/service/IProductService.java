package com.example.productmanager.service;

import com.example.productmanager.model.Product;
import java.util.List;

public interface IProductService {
    List<Product> findAll();
    Product findById(int id);
    void save(Product product);
    void deleteById(int id);
}
