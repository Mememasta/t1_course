package ru.vtb.t1.course.product.model.dto;

/**
 * @author mchuchalov on 01.05.2024
 */
public class ProductDTO {

    private final Long id;

    private final Long userId;

    private final String accountNumber;

    private final String balance;

    private final ProductType productType;


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

    public ProductType getProductType() {
        return productType;
    }


    public ProductDTO(Long id, Long userId, String accountNumber, String balance, String productType) {
        this.id = id;
        this.userId = userId;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.productType = ProductType.getValue(productType);
    }


    @Override
    public String toString() {
        return "ProductDTO{" +
                "id=" + id +
                ", userId=" + userId +
                ", accountNumber='" + accountNumber + '\'' +
                ", balance='" + balance + '\'' +
                ", productType=" + productType +
                '}';
    }
}
