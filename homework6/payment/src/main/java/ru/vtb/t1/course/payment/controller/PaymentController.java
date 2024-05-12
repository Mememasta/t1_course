package ru.vtb.t1.course.payment.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vtb.t1.course.payment.model.PaymentInfoDto;
import ru.vtb.t1.course.payment.model.PaymentRequest;
import ru.vtb.t1.course.payment.service.PaymentService;

@RestController
@RequestMapping("api/v1/payment")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public ResponseEntity<PaymentInfoDto> paymentForUser(@RequestBody PaymentRequest request) {
        PaymentInfoDto payment = paymentService.getPaymentInfoByUserId(request.userId(), request.productType(), request.balance());
        return ResponseEntity.ok(payment);
    }

}
