package com.epam.spring.core.misc.strategies;

import com.epam.spring.core.domain.entities.Event;
import com.epam.spring.core.domain.entities.User;

/**
 * @author Dmytro_Adonin
 * @since 2/5/2016.
 */
public interface DiscountStrategy {

    float calculateDiscount(User user, Event event);

}
