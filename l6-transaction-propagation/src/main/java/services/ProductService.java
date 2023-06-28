package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import repositories.ProductRepository;

@Service
public class ProductService {

    /**
     * Propagation defines our business logic's transaction boundary. Spring manages to start
     * and pause a transaction according to our propagation setting.
     *
     *
     * TRANSACTION PROPAGATION LEVELS:
     *
     * 1. (Default) REQUIRED
     *    It create a transaction if I don't have a transaction,
     *    it uses the transaction of the method if it has a transaction
     *
     * 2. REQUIRES_NEW
     *    Always make a new transaction even if there is already another one
     *
     * 3. MANDATORY
     *    It makes sure this method annotated with it have already a transaction
     *    (doesn't make a new transaction, only works if there is already a transaction available)
     *
     * 4. NEVER
     *    this method should never be called with a transaction
     *
     * 5. SUPPORTS
     *    the method will execute within a transaction if there is a transaction
     *    if there is no transaction it will be called without a transaction
     *      
     * 6. NOT_SUPPORTED
     *    that means the method will be called without transaction even you have a transaction
     *    (this method always executed without a transaction)
     *
     * 7. NESTED (not so much used)
     *    it means if we have a transaction inside another transaction and the big transaction want
     *    to rollback, all transactions inside it will roll back too
     *
     *    unlike REQUIRE_NEW as the big transaction rollback doesn't affect the inner
     *    transactions if committed
     */

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addProduct(String name) {
        productRepository.addProduct(name);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void addTenProducts() {
        for (int i=1 ; i<=10 ; i++) {
            productRepository.addProduct("product" + i);
            if (i == 5) {
                throw new RuntimeException(":(");
            }
        }
    }
}
