package ru.vtb.t1.course.payment.exception;


import ru.vtb.t1.course.payment.model.ProductType;

public class IntegrationException extends RuntimeException {

    public IntegrationException(String message, Long userId, ProductType productType) {
        super(String.format(message, userId, productType));
    }

    public IntegrationException(String message, Long userId) {
        super(String.format(message, userId));
    }
}
