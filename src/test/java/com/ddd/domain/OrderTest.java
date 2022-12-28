package com.ddd.domain;

import com.ddd.enums.OrderState;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;

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
            shippingInfo.setShippingZipcode("00123");
            OrderLine orderLine = new OrderLine(new Product(), 10000, 1);
            Order order = new Order(Arrays.asList(orderLine), shippingInfo);
            order.setState(OrderState.PAYMENT_WAITING);

            // when
            ShippingInfo newShippingInfo = new ShippingInfo();
            newShippingInfo.setShippingZipcode("01234");
            order.changeShippingInfo(newShippingInfo);

            // then
            assertThat(order.getShippingInfo().getShippingZipcode()).isEqualTo("01234");
        }

        @Test
        void fail() {
            // given
            Order order = new Order();
            order.setState(OrderState.DELIVERING);

            // when
            ShippingInfo newShippingInfo = new ShippingInfo();
            newShippingInfo.setShippingZipcode("01234");

            assertThrows(IllegalStateException.class, () -> order.changeShippingInfo(newShippingInfo));
        }
    }
}
