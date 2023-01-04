package com.ddd.interfaces;

import com.ddd.domain.Customer;
import com.ddd.domain.Money;
import com.ddd.domain.OrderLine;

import java.util.List;

public interface RuleDiscounter {
    Money applyRules(Customer customer, List<OrderLine> orderLines);
}
