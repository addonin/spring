package com.epam.spring.core.services.impl;

import com.epam.spring.core.domain.Event;
import com.epam.spring.core.domain.User;
import com.epam.spring.core.misc.strategies.DiscountStrategy;
import com.epam.spring.core.services.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Dmytro_Adonin
 * @since 2/5/2016.
 */
@Service
public class DiscountServiceImpl implements DiscountService {

    @Autowired
    private List<DiscountStrategy> strategies;

    public float getDiscount(User user, Event event) {
        float discount = 0;
        for (DiscountStrategy strategy : strategies) {
            discount += strategy.calculateDiscount(user, event);
        }
        return discount;
    }
}
