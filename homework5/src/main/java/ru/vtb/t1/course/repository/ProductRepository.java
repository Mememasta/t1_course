package ru.vtb.t1.course.repository;

import org.springframework.stereotype.Repository;
import ru.vtb.t1.course.model.ProductDTO;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author mchuchalov on 01.05.2024
 */
@Repository
public class ProductRepository {

    private final Statement statement;

    public ProductRepository(Statement statement) {
        this.statement = statement;
    }

    public void save(ProductDTO productDTO) {
        var createQuery = String.format("INSERT INTO products(id, user_id, account_number, balance, product_type) VALUES (%s, %s, '%s', '%s', '%s')", productDTO.getId(), productDTO.getUserId(), productDTO.getAccountNumber(), productDTO.getBalance(), productDTO.getProductType());
        execute(createQuery);
    }

    public ProductDTO findById(Long productId) {
        var findByIdQuery = String.format("SELECT * FROM products WHERE id = %s", productId);
        var products = executeWithResult(findByIdQuery);
        if (products.isEmpty()) {
            return null;
        } else if (products.size() == 1) {
            return products.get(0);
        }
        throw new RuntimeException("found not unique products");
    }

    public List<ProductDTO> findAllByUserId(Long userId) {
        var findAllQuery = String.format("SELECT * FROM products WHERE user_id = %s", userId);
        return executeWithResult(findAllQuery);
    }

    private void execute(String sql) {
        try {
            statement.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private List<ProductDTO> executeWithResult(String sql) {
        List<ProductDTO> products = new ArrayList<>();
        try {
            var result = statement.executeQuery(sql);
            while (result.next()) {
                var product = new ProductDTO(result.getLong("id"), result.getLong("user_id"), result.getString("account_number"), result.getString("balance"), result.getString("product_type"));
                products.add(product);
            }
            return products;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
