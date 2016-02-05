package com.epam.spring.core.context;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author Dmytro_Adonin
 * @since 2/5/2016.
 */
@Configuration
@Import({DiscountStrategyContext.class})
@ComponentScan({"com.epam.spring.core.services", "com.epam.spring.core.dao"})
public class CoreApplicationContext {
}
