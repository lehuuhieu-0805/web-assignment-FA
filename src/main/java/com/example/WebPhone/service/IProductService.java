package com.example.WebPhone.service;

import com.example.WebPhone.entity.Product;
import com.example.WebPhone.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    public List<Product> findAll();
    public void save(Product product);
    public void remove(int id);
    public Optional<Product> getProductById(int id);
}
