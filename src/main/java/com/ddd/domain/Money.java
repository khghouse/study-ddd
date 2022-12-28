package com.ddd.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Money {
    private int value;

    public Money(int value) {
        this.value = value;
    }
}
