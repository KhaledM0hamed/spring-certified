package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import repositories.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    /**
     * Default Isolation level --> Read Committed
     *
     * READ UNCOMMITTED
     * READ COMMITTED
     * REPEATABLE READ
     * SERIALIZABLE
     *
     * PROBLEMS:
     *      - dirty reads
     *      - repeatable read
     *      - phantom read
     */

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public void addTenProduct() {
        for (int i=1; i <= 10; i++) {
            productRepository.addProduct("product " + i);
        }
    }
}
