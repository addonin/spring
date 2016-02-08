package com.epam.spring.core.context;

import com.epam.spring.core.domain.Auditorium;
import com.epam.spring.core.misc.strategies.DiscountStrategy;
import com.epam.spring.core.misc.strategies.impl.BirthdayDiscountStrategy;
import com.epam.spring.core.misc.strategies.impl.TenthTicketDiscountStrategy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import java.util.List;

/**
 * @author Dmytro_Adonin
 * @since 2/5/2016.
 */
@Configuration
@Import({DiscountStrategyContext.class})
@ComponentScan({"com.epam.spring.core.services", "com.epam.spring.core.dao"})
@PropertySources({
        @PropertySource(name="auditorium1properties", value = "classpath:auditorium1.properties"),
        @PropertySource(name="auditorium2properties", value = "classpath:auditorium2.properties")})
public class CoreApplicationContext {

    @Bean
    private static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Value("${auditorium1.name}")
    private String auditorium1name;

    @Value("${auditorium1.seats}")
    private int auditorium1seats;

    @Value("#{'${auditorium1.vips}'.split(',')}")
    private List<Integer> auditorium1vips;

    @Value("${auditorium2.name}")
    private String auditorium2name;

    @Value("${auditorium2.seats}")
    private int auditorium2seats;

    @Value("#{'${auditorium2.vips}'.split(',')}")
    private List<Integer> auditorium2vips;

    @Bean
    public Auditorium auditorium1() {
        return new Auditorium(auditorium1name, auditorium1seats, auditorium1vips);
    }

    @Bean
    public Auditorium auditorium2() {
        return new Auditorium(auditorium2name, auditorium2seats, auditorium2vips);
    }

    @Bean
    public DiscountStrategy birthdayDiscountStrategy() {
        return new BirthdayDiscountStrategy();
    }

    @Bean
    public DiscountStrategy tenthTicketDiscountStrategy() {
        return new TenthTicketDiscountStrategy();
    }

}
