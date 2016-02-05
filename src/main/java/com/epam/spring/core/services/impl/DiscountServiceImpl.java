package com.epam.spring.core.services.impl;

import com.epam.spring.core.domain.Event;
import com.epam.spring.core.domain.User;
import com.epam.spring.core.misc.strategies.DiscountStrategy;
import com.epam.spring.core.services.DiscountService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

/**
 * @author Dmytro_Adonin
 * @since 2/5/2016.
 */
@Service
public class DiscountServiceImpl implements DiscountService {

    private List<DiscountStrategy> strategies;

    public float getDiscount(User user, Event event, Instant datetime) {
        return 0;
    }
}
