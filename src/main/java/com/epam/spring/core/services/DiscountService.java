package com.epam.spring.core.services;

import com.epam.spring.core.domain.entities.Event;
import com.epam.spring.core.domain.entities.User;

/**
 * @author Dmytro_Adonin
 * @since 2/5/2016.
 */
public interface DiscountService {

    float getDiscount(User user, Event event);

}
