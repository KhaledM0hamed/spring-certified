package repositories;

import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ProductRepository {

    private final JdbcTemplate jdbcTemplate;


    @Autowired
    public ProductRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addProduct(Product product) {
        String sql = "INSERT INTO product VALUES (null, ?, ?)";
        jdbcTemplate.update(sql, product.getName(), product.getPrice());
    }

    public List<Product> getProducts() {
        String sql = "SELECT  * FROM product";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Product p = new Product();
            p.setId(rs.getInt("id"));
            p.setName(rs.getString("name"));
            p.setPrice(rs.getDouble("price"));
            return p;
        });
    }
}
