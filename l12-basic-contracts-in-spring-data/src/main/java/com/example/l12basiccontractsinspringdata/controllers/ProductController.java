package com.example.l12basiccontractsinspringdata.controllers;

import com.example.l12basiccontractsinspringdata.entities.Product;
import com.example.l12basiccontractsinspringdata.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping(path = "/sort")
    public Iterable<Product> getAllSortedDescendingById() {
        return productRepository.findAll(Sort.by("id").descending());
    }

    @GetMapping(path = "/page/{page}")
    public List<Product> getProductByPage(@PathVariable int page) {
        Sort s = Sort.by("id").descending();
        return productRepository.findAll(PageRequest.of(page, 2, s)).getContent();
    }

    @GetMapping(path = "/name/{name}/{page}")
    public List<Product> getProductByName(@PathVariable String name, @PathVariable int page) {
        Pageable p = PageRequest.of(page, 2, Sort.by("id").descending());
        return productRepository.findProductByName(name, p);
    }
}
