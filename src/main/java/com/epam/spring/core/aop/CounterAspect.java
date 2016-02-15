package com.epam.spring.core.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Dmytro_Adonin
 * @since 2/15/2016.
 */
@Aspect
@Component
public class CounterAspect {

    private Map<Integer, Integer> gettingEventStatistics = new HashMap<>();
    private Map<Integer, Integer> gettingTicketPriceForEventStatistics = new HashMap<>();
    private Map<Integer, Integer> bookingTicketsForEventStatistics = new HashMap<>();

    @Pointcut("execution(com.epam.spring.core.domain.Event com.epam.spring.core.services.EventService+.getById(Integer))")
    private void gettingEvent() {}

    @Pointcut("execution(float com.epam.spring.core.services.BookingService+.getTicketPrice(com.epam.spring.core.domain.User, Integer, Integer))")
    private void gettingTicketPrice() {}

    @Pointcut("execution(java.util.List<com.epam.spring.core.domain.Ticket> com.epam.spring.core.services.BookingService+.bookTickets(com.epam.spring.core.domain.User, Integer, java.util.List<Integer>))")
    private void bookingTickets() {}

    @AfterReturning(pointcut = "gettingEvent()", returning = "retVal")
    public void countGettingEvent(JoinPoint joinPoint, Object retVal) {
        Integer id = (Integer) joinPoint.getArgs()[0];
        if (id != null && retVal != null) {
            Integer currentCounterValue = gettingEventStatistics.get(id);
            gettingEventStatistics.put(id, currentCounterValue == null ? 1 : currentCounterValue + 1);
        }
    }

    @Before("gettingTicketPrice()")
    public void countGettingTicketPriceForEvent(JoinPoint joinPoint) {
        Integer id = (Integer) joinPoint.getArgs()[1];
        if (id != null) {
            Integer currentCounterValue = gettingTicketPriceForEventStatistics.get(id);
            gettingTicketPriceForEventStatistics.put(id, currentCounterValue == null ? 1 : currentCounterValue + 1);
        }
    }

    @After("bookingTickets()")
    public void countBookingTicketsForEvent(JoinPoint joinPoint) {
        Integer id = (Integer) joinPoint.getArgs()[1];
        List<Integer> tickets = (List<Integer>) joinPoint.getArgs()[2];
        if (id != null && tickets != null) {
            Integer currentCounterValue = bookingTicketsForEventStatistics.get(id);
            int ticketsAmount = tickets.size();
            bookingTicketsForEventStatistics.put(id,
                    currentCounterValue == null ? ticketsAmount : currentCounterValue + ticketsAmount);
        }
    }

}
