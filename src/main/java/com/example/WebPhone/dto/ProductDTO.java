package com.example.WebPhone.dto;

import lombok.Data;

@Data
public class ProductDTO {
    private int id;
    private String name;
    private String image;
    private int quantity;
    private float price;
    private String description;
}
