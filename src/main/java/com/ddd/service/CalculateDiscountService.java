package com.ddd.service;

import com.ddd.component.DroolsRuleEngine;
import com.ddd.domain.Money;
import com.ddd.domain.OrderLine;

import java.util.List;

public class CalculateDiscountService {

    // 특정 모듈을 의존하고 있는 DroolsRuleEngine이 완벽하게 동작해야 CalculateDiscountService 테스트가 가능하다.
    // 다른 할인 방식을 적용하기 위해 코드 수정이 필요하다.
    private DroolsRuleEngine ruleEngine;

    public CalculateDiscountService() {
        ruleEngine = new DroolsRuleEngine();
    }

    public Money calculateDiscount(List<OrderLine> orderLines, String customerId) {
        /**
         * 할인 금액 계산
         */
        return null;
    }
}
