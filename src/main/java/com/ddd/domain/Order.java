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

    public Order(List<OrderLine> orderLines, ShippingInfo shippingInfo) {
        setOrderLines(orderLines);
        setShippingInfo(shippingInfo);
    }

    private void setOrderLines(List<OrderLine> orderLines) {
        verifyAtLeastOneOrMoreOrderLines(orderLines);
        this.orderLines = orderLines;
        calculateTotalAmounts();
    }

    private void setShippingInfo(ShippingInfo shippingInfo) {
        if (shippingInfo == null) { // 주문 생성 시, 배송지 정보 필수
            throw new IllegalArgumentException("no ShippingInfo");
        }
        this.shippingInfo = shippingInfo;
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
        verifyNotYetShipped();
        this.shippingInfo = newShippingInfo;
    }

    // 결제 대기, 상품준비중 상태일때만 배송지 변경 가능
    private boolean isShippingChangeable() {
        return state == OrderState.PAYMENT_WAITING || state == OrderState.PREPARING;
    }

    // 출고 상태로 변경하기
    public void changeShipped() {

    }

    // 주문 취소하기
    public void cancle() {
        verifyNotYetShipped();
        this.state = OrderState.CANCELED;
    }

    // 상품 출고 이전 주문인지 체크
    private void verifyNotYetShipped() {
        if (state != OrderState.PAYMENT_WAITING && state != OrderState.PREPARING) {
            throw new IllegalStateException("aleady shipped");
        }
    }

    // 주문 결제하기
    public void completePayment() {

    }
}
