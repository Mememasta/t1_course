package ru.vtb.t1.course.payment.model;

public record PaymentRequest(
        Long userId,

        ProductType productType,

        Long balance
) {
}
