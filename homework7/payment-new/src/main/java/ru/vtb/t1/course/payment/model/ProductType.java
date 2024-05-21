package ru.vtb.t1.course.payment.model;

import java.util.Arrays;

/**
 * @author mchuchalov on 01.05.2024
 */
public enum ProductType {
    ACCOUNT, CARD;

    public static ProductType getValue(String productType) {
        return Arrays.stream(ProductType.values())
                .filter(it -> it.name().equals(productType))
                .findFirst()
                .orElseThrow();
    }
}
