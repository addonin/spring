package com.epam.spring.core.misc.strategies;

import com.epam.spring.core.domain.Event;
import com.epam.spring.core.domain.User;

/**
 * @author Dmytro_Adonin
 * @since 2/5/2016.
 */
public interface DiscountStrategy {

    float calculateDiscount(User user, Event event);

}
