package com.example.l10moredetailsonrest.services;

import com.example.l10moredetailsonrest.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public void addProduct(String name) {
        productRepository.addProduct(name);
    }
}
