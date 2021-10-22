package com.example.WebPhone.controller;

import com.example.WebPhone.entity.Product;
import com.example.WebPhone.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    IProductService IProductService;

    @GetMapping(value = {"/", "/product"})
    public String Products(Model model){
        List<Product> listProduct = IProductService.findAll();
        model.addAttribute("list", listProduct);
        model.addAttribute("product", new Product());
        return "index";
    }

    @PostMapping("/product")
    public String saveProduct(@RequestParam("productImage")MultipartFile file,
                              @ModelAttribute("productDTO")Product product) throws IOException {
        if (!file.isEmpty()) {
            byte[] fileContent = Base64.getEncoder().encode(file.getBytes());
            product.setImage(new String(fileContent));
            product.setContentType(file.getContentType());
        }
        IProductService.save(product);
        return "redirect:/";
    }
    @GetMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable int id){
        IProductService.remove(id);
        return "redirect:/";
    }

    @PostMapping("/product/update")
    public String updateProduct(@RequestParam("productImage")MultipartFile file,
                                @ModelAttribute("product")Product newProduct) throws IOException {
        Product product = IProductService.getProductById(newProduct.getId()).get();
        if (!file.isEmpty()) {
            byte[] fileContent = Base64.getEncoder().encode(file.getBytes());
            product.setImage(new String(fileContent));
            product.setContentType(file.getContentType());
        }
        product.setName(newProduct.getName());
        product.setDescription(newProduct.getDescription());
        product.setQuantity(newProduct.getQuantity());
        product.setPrice(newProduct.getPrice());
        IProductService.save(product);
        return "redirect:/";
    }
}
