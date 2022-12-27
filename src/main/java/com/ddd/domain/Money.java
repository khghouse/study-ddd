package com.ddd.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Money {
    private int amounts;

    public Money(int amounts) {
        this.amounts = amounts;
    }
}
