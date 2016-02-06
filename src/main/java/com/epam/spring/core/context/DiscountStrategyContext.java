package com.epam.spring.core.context;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Dmytro_Adonin
 * @since 2/5/2016.
 */
@Configuration
@ComponentScan({"com.epam.spring.core.misc.strategies."})
public class DiscountStrategyContext {
}
