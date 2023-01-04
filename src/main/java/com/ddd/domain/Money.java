package com.ddd.domain;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Money {
    private int value;

    public Money(int value) {
        this.value = value;
    }

    public Money add(Money money) {
        return new Money(this.value + money.getValue());
    }

    public Money multiply(int multiplier) {
        return new Money(this.value * multiplier);
    }
}
