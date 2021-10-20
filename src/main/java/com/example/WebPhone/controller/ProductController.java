package com.example.WebPhone.controller;

import com.example.WebPhone.entity.Product;
import com.example.WebPhone.service.IProductService;
import com.example.WebPhone.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
public class ProductController {
    public static String uploadDir = System.getProperty("user.dir") + "/src/main/resources/img";
    @Autowired
    IProductService IProductService;

    @GetMapping("/product")
    public String Products(Model model){
        List<Product> listProduct = IProductService.findAll();
        model.addAttribute("list", listProduct);
        return "index";
    }

    @PostMapping("/product")
    public String productAddPost(@RequestParam("productImage")MultipartFile file,
                                 @RequestParam("image")String image) throws IOException {
        Product product = new Product();
        product.setId(product.getId());
        product.setName(product.getName());
        String imageUUID;
        if (!file.isEmpty()) {
            imageUUID = file.getOriginalFilename();
            Path fileNameAndPath = Paths.get(uploadDir, imageUUID);
            Files.write(fileNameAndPath, file.getBytes());
        } else {
            imageUUID = image;
        }
        product.setImage(imageUUID);
        product.setQuantity(product.getQuantity());
        product.setPrice(product.getPrice());
        product.setDescription(product.getDescription());
        System.out.println(product.getName());
        IProductService.save(product);
        return "index";
    }
}
