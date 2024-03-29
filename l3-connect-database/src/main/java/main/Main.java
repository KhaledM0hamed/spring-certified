package main;

import config.ProjectConfig;
import model.Product;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import repositories.ProductRepository;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        try(var context = new AnnotationConfigApplicationContext(ProjectConfig.class)) {
            ProductRepository productRepository = context.getBean(ProductRepository.class);
//            Product product = new Product();
//            product.setName("Beer");
//            product.setPrice(10.0);
//            productRepository.addProduct(product);
            List<Product> products = productRepository.getProducts();
            products.forEach(System.out::println);
        }
    }
}