package com.example.WebPhone.controller;

import com.example.WebPhone.entity.Product;
import com.example.WebPhone.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductRestController {

    @Autowired
    IProductService IProductService;

    @RequestMapping("/product/update/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable int id){
        return new ResponseEntity<Product>(IProductService.getProductById(id).get(), HttpStatus.OK);
    }
}
