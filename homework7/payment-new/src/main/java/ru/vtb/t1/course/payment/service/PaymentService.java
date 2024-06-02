package ru.vtb.t1.course.payment.service;

import ru.vtb.t1.course.payment.model.PaymentInfoDto;
import ru.vtb.t1.course.payment.model.ProductType;

public interface PaymentService {

    PaymentInfoDto getPaymentInfoByUserId(Long userId, ProductType productType, Long balance);

}
