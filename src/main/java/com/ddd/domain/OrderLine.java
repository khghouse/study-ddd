package com.ddd.domain;

import lombok.Data;

// 주문 항목을 표현
@Data
public class OrderLine {
    private Product product;
    private Money price;
    private int quantity;
    private Money amounts;

    public OrderLine(Product product, Money price, int quantity) {
        this.product = product;
        this.price = price;
        this.quantity = quantity;
        this.amounts = calculateAmounts();
    }

    private Money calculateAmounts() {
        return new Money(this.price.getValue() * this.quantity);
    }
}
