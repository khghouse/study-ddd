package com.ddd.domain;

import com.ddd.enums.OrderState;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Order {
    private List<OrderLine> orderLines;
    private Money totalAmounts;
    private OrderState state;
    private ShippingInfo shippingInfo;

    public Order(List<OrderLine> orderLines) {
        setOrderLines(orderLines);
    }

    private void setOrderLines(List<OrderLine> orderLines) {
        verifyAtLeastOneOrMoreOrderLines(orderLines);
        this.orderLines = orderLines;
        calculateTotalAmounts();

    }

    private void calculateTotalAmounts() {
        int sum = orderLines.stream()
                .mapToInt(OrderLine::getAmounts)
                .sum();
        this.totalAmounts = new Money(sum);
    }

    // 최소 한 종류 이상의 상품을 주문하려고 하는가?
    private void verifyAtLeastOneOrMoreOrderLines(List<OrderLine> orderLines) {
        if (orderLines == null || orderLines.isEmpty()) {
            throw new IllegalArgumentException("no OrderLine");
        }
    }

    // 배송지 정보 변경하기
    public void changeShippingInfo(ShippingInfo newShippingInfo) {
        if (!isShippingChangeable()) {
            throw new IllegalStateException("can't change shipping in " + state);
        }
        this.shippingInfo = newShippingInfo;
    }

    private boolean isShippingChangeable() {
        return state == OrderState.PAYMENT_WAITING || state == OrderState.PREPARING;
    }

    // 출고 상태로 변경하기
    public void changeShipped() {

    }

    // 주문 취소하기
    public void cancle() {

    }

    // 주문 결제하기
    public void completePayment() {

    }
}
