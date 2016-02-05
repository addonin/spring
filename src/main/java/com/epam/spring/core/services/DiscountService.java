package com.epam.spring.core.services;

import com.epam.spring.core.domain.Event;
import com.epam.spring.core.domain.User;

import java.time.Instant;

/**
 * @author Dmytro_Adonin
 * @since 2/5/2016.
 */
public interface DiscountService {

    float getDiscount(User user, Event event, Instant datetime);



}
