package com.epam.spring.core.misc.strategies.impl;

import com.epam.spring.core.domain.Event;
import com.epam.spring.core.domain.User;
import com.epam.spring.core.misc.strategies.DiscountStrategy;

/**
 * @author Dmytro_Adonin
 * @since 2/5/2016.
 */
public class TenthTicketDiscountStrategy implements DiscountStrategy {

    @Override
    public float calculateDiscount(User user, Event event) {
        return 5;
    }
}
