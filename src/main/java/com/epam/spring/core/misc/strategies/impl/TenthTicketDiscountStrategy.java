package com.epam.spring.core.misc.strategies.impl;

import com.epam.spring.core.domain.Event;
import com.epam.spring.core.domain.User;
import com.epam.spring.core.misc.strategies.DiscountStrategy;
import org.springframework.stereotype.Component;

/**
 * @author Dmytro_Adonin
 * @since 2/5/2016.
 */
@Component
public class TenthTicketDiscountStrategy implements DiscountStrategy {

    @Override
    public float calculateDiscount(User user, Event event) {
        int soldTickets = 0;//user.getTickets().size();
        return soldTickets > 10 && (soldTickets + 1) % 10 == 0 ? 5 : 0;
    }
}
