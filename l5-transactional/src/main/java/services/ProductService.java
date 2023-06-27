package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repositories.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

//    @Transactional
    /**
     * By default it rollback the RunTimeException but does not rollback any other exception.
     */
//    @Transactional(noRollbackFor = RuntimeException.class)

    /**
     * if you want to change the default behavior
     */
    @Transactional(rollbackFor = Exception.class)
    /**
     * that mean change the default (runTimeExceptions) and rollback for any kind of checked exceptions.
     */
    public void addProduct(String name) {
        productRepository.addProduct(name);
        throw new RuntimeException("::");
    }
    /**
     * NOTE:
     * BTW if you catch the exception inside the method that mean rollback will not happen cause
     * the aspect doesn't feel the exception. 
     */
}
