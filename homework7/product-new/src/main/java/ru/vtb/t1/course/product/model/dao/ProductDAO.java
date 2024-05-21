package ru.vtb.t1.course.product.model.dao;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class ProductDAO {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "account_number")
    private String accountNumber;

    @Column(name = "balance")
    private String balance;

    @Column(name = "product_type")
    private String productType;

    public ProductDAO(Long id, Long userId, String accountNumber, String balance, String productType) {
        this.id = id;
        this.userId = userId;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.productType = productType;
    }

    public ProductDAO() {

    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getBalance() {
        return balance;
    }

    public String getProductType() {
        return productType;
    }
}
