package com.epam.spring.core.aop;

import com.epam.spring.core.domain.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Dmytro_Adonin
 * @since 2/15/2016.
 */
@Aspect
@Component
public class DiscountAspect {

    private volatile int total;

    private Map<Integer, Integer> discountTimesPerUserStatistics = new HashMap<>();

    @Pointcut("execution(float com.epam.spring.core.misc.strategies.DiscountStrategy+.calculateDiscount(com.epam.spring.core.domain.User, com.epam.spring.core.domain.Event))")
    private void calculatingDiscount() {}

    @AfterReturning(pointcut = "calculatingDiscount()", returning = "retVal")
    public void countDiscounts(JoinPoint joinPoint, Object retVal) {
        User user = (User) joinPoint.getArgs()[0];
        float discount = (float) retVal;
        if (discount > 0 && user != null) {
            total++;
            Integer userId = user.getId();
            Integer currentCounterValue = discountTimesPerUserStatistics.get(userId);
            discountTimesPerUserStatistics.put(userId, currentCounterValue == null ? 1 : currentCounterValue + 1);
        }
    }

}
