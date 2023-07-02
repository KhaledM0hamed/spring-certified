package com.example.l11springdata.repositories;

import com.example.l11springdata.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    /**
     * you may just use the method and JPA will implement it if you don't provide the query
     */
    
    @Query("SELECT p FROM Product p WHERE p.name=:name")
    Product findProductByName(String name);
}
