package com.ddd.domain;

import com.ddd.enums.OrderState;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
public class OrderTest {

    @Nested
    class changeShippingInfoTest {
        @Test
        void success() {
            // given
            Address address = new Address("서울시", "의사당대로", "00123");
            ShippingInfo shippingInfo = new ShippingInfo();
            shippingInfo.setAddress(address);
            OrderLine orderLine = new OrderLine(new Product(), new Money(10000), 1);
            Order order = new Order(Arrays.asList(orderLine), shippingInfo, OrderState.PAYMENT_WAITING);

            // when
            Address newAddress = new Address("서울시", "의사당대로", "01234");
            ShippingInfo newShippingInfo = new ShippingInfo();
            newShippingInfo.setAddress(newAddress);
            order.changeShippingInfo(newShippingInfo);

            // then
            assertThat(order.getShippingInfo().getAddress().getZipcode()).isEqualTo("01234");
        }

        @Test
        void fail() {
            // given
            Order order = new Order();

            // when
            Address newAddress = new Address("서울시", "의사당대로", "01234");
            ShippingInfo newShippingInfo = new ShippingInfo();
            newShippingInfo.setAddress(newAddress);

            assertThrows(IllegalStateException.class, () -> order.changeShippingInfo(newShippingInfo));
        }
    }

    @Test
    void uuidTest() {
        System.out.println(UUID.randomUUID());
        System.out.println(UUID.randomUUID());
        System.out.println(UUID.randomUUID());
    }
}
