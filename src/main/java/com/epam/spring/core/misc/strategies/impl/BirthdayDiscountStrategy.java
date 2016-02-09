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
public class BirthdayDiscountStrategy implements DiscountStrategy {

    public float calculateDiscount(User user, Event event) {
        //TODO check if user's birthday today and give some discount
        return 0;
    }

}
