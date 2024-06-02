package ru.vtb.t1.course.payment.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaymentInfoDto extends ErrorResponse {

    private List<ProductDTO> products;

    public PaymentInfoDto(List<ProductDTO> products) {
        this.products = products;
    }

    public List<ProductDTO> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return "PaymentInfoDto{" +
                "products=" + products +
                '}';
    }
}
