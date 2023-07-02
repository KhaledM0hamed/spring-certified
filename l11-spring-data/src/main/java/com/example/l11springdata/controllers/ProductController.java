package com.example.l11springdata.controllers;

import com.example.l11springdata.entities.Product;
import com.example.l11springdata.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping(path = "/add")
    public void addProduct(@RequestBody Product product) {
        productRepository.save(product);
    }

    @GetMapping(path = "/get/{name}")
    public Product getProduct(@PathVariable String name) {
        return productRepository.findProductByName(name);
    }
}
