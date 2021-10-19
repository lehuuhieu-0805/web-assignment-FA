package com.example.WebPhone.controller;

import com.example.WebPhone.entity.Product;
import com.example.WebPhone.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    IProductService IProductService;

    @GetMapping("/product")
    public String Products(Model model){
        List<Product> listProduct = IProductService.findAll();
        model.addAttribute("list", listProduct);
        return "index";
    }
}
