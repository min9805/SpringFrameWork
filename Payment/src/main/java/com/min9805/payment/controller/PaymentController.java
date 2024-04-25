package com.min9805.payment.controller;

import com.min9805.payment.service.PaymentService;
import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.exception.IamportResponseException;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/payment")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Payments", description = "결제 API")
public class PaymentController {
    private final PaymentService paymentService;

    @PostMapping("/validation/{imp_uid}")
    public IamportResponse<Payment> validateIamport(@PathVariable String imp_uid) throws IamportResponseException, IOException {
        log.info("imp_uid: {}", imp_uid);
        log.info("validateIamport");
        return paymentService.validateIamport(imp_uid);
    }

    @PostMapping("/order")
    public ResponseEntity<String> processOrder(@RequestBody String jsonOrder) {
        // 주문 정보를 로그에 출력
        log.info("Received orders: {}", jsonOrder);

        // 성공적으로 받아들였다는 응답 반환
        return ResponseEntity.ok("주문 정보가 성공적으로 받아들여졌습니다.");
    }

    @PostMapping("/cancel/{imp_uid}")
    public IamportResponse<Payment> cancelPayment(@PathVariable String imp_uid) throws IamportResponseException, IOException {
        return paymentService.cancelPayment(imp_uid);
    }
}


