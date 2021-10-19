package com.example.WebPhone.repository;

import com.example.WebPhone.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, String> {
}
