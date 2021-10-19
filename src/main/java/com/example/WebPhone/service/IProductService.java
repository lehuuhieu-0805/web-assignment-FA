package com.example.WebPhone.service;

import com.example.WebPhone.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface IProductService {
    public List<Product> findAll();
    public void save(Product product);
}
