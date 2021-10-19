package com.example.WebPhone.service;

import com.example.WebPhone.repository.IProductRepository;
import com.example.WebPhone.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductRepository IProductRepository;

    @Override
    public List<Product> findAll() {
        return IProductRepository.findAll();
    }

    @Override
    public void save(Product product) {
        IProductRepository.save(product);
    }
}
