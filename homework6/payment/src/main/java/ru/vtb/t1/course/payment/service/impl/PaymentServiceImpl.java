package ru.vtb.t1.course.payment.service.impl;

import org.springframework.stereotype.Service;
import ru.vtb.t1.course.payment.client.ProductClient;
import ru.vtb.t1.course.payment.exception.IntegrationException;
import ru.vtb.t1.course.payment.model.PaymentInfoDto;
import ru.vtb.t1.course.payment.model.ProductDTO;
import ru.vtb.t1.course.payment.model.ProductType;
import ru.vtb.t1.course.payment.service.PaymentService;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final ProductClient productClient;

    public PaymentServiceImpl(ProductClient productClient) {
        this.productClient = productClient;
    }

    @Override
    public PaymentInfoDto getPaymentInfoByUserId(Long userId, ProductType productType, Long balance) {
        List<ProductDTO> products = productClient.findProductsByUserId(userId)
                .stream()
                .filter(p -> p.getProductType().equals(productType))
                .toList();

        if (products.isEmpty()) {
            throw new IntegrationException("Для клиента %s не найден продукт с типом %s", userId, productType);
        }

        List<ProductDTO> productsWithSufficientFunds = products.stream()
                .filter(p -> Long.parseLong(p.getBalance()) > balance)
                .toList();

        if (productsWithSufficientFunds.isEmpty()) {
            throw new IntegrationException("У клиента %s нет продуктов в которых достаточно средств", userId);
        }

        return new PaymentInfoDto(products);
    }
}
