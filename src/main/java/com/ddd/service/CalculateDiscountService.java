package com.ddd.service;

import com.ddd.component.DroolsRuleDiscounter;
import com.ddd.domain.Customer;
import com.ddd.domain.Money;
import com.ddd.domain.OrderLine;
import com.ddd.interfaces.RuleDiscounter;

import java.util.List;

public class CalculateDiscountService {

    private RuleDiscounter ruleDiscounter = new DroolsRuleDiscounter();

    public CalculateDiscountService(RuleDiscounter ruleDiscounter) {
        this.ruleDiscounter = ruleDiscounter;
    }

    public Money calculateDiscount(List<OrderLine> orderLines, String customerId) {
        Customer customer = new Customer(); // 구매자 조회
        return ruleDiscounter.applyRules(customer, orderLines);
    }
}
