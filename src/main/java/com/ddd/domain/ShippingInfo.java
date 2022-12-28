package com.ddd.domain;

import lombok.Data;

@Data
public class ShippingInfo {
    private Receiver receiver;
    private Address address;
}
