package com.ddd.domain;

import com.ddd.enums.OrderState;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
public class OrderTest {

    @Nested
    class changeShippingInfoTest {
        @Test
        void success() {
            // given
            ShippingInfo shippingInfo = new ShippingInfo();
            shippingInfo.setMessage("서울시");
            Order order = new Order();
            order.setShippingInfo(shippingInfo);
            order.setState(OrderState.PAYMENT_WAITING);

            // when
            ShippingInfo newShippingInfo = new ShippingInfo();
            newShippingInfo.setMessage("서울특별시");
            order.changeShippingInfo(newShippingInfo);

            // then
            assertThat(order.getShippingInfo().getMessage()).isEqualTo("서울특별시");
        }

        @Test
        void fail() {
            // given
            Order order = new Order();
            order.setState(OrderState.DELIVERING);

            // when
            ShippingInfo newShippingInfo = new ShippingInfo();
            newShippingInfo.setMessage("서울특별시");

            assertThrows(IllegalStateException.class, () -> order.changeShippingInfo(newShippingInfo));
        }
    }
}
