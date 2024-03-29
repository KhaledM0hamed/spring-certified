package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.ProductRepository;

@Service
public class ProductDeliveryService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductDeliveryService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addSomeProduct() {
        productRepository.add();
        productRepository.add();
        productRepository.add();
    }
}
