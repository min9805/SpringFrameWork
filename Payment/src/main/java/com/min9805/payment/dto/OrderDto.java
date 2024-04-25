package com.min9805.payment.dto;

import com.min9805.payment.domain.Order;
import lombok.Getter;

@Getter
public class OrderDto {
    Long productId;
    String productName;
    int price;
    int quantity;
    String impUid;
    String merchantUid;

    public Order toEntity() {
        return Order.builder()
                .productId(productId)
                .productName(productName)
                .price(price)
                .quantity(quantity)
                .impUid(impUid)
                .merchantUid(merchantUid)
                .build();
    }
}
