package com.ddd.service;

import com.ddd.domain.Order;
import org.springframework.transaction.annotation.Transactional;

public class CancelOrderService {

    @Transactional
    public void cancelOrder(String orderId) {
        Order order = new Order(); // 주문 조회가 구현되기 전까지 사용
        // Order order = findOrderById(orderId); // 주문 조회

        if (order == null) {
            throw new IllegalArgumentException("not find orderId");
        }
        order.cancel(); // 주문 취소 -> 주문 도메일 모델을 사용해서 기능을 구현한다.
    }
}
