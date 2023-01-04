package com.ddd.component;

import com.ddd.domain.Customer;
import com.ddd.domain.Money;
import com.ddd.domain.OrderLine;
import com.ddd.interfaces.RuleDiscounter;

import java.util.List;

public class DroolsRuleDiscounter implements RuleDiscounter {
    @Override
    public Money applyRules(Customer customer, List<OrderLine> orderLines) {
        return null;
    }
}
