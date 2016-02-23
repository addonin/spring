package com.epam.spring.core.aop;

import com.epam.spring.core.domain.stats.BookingTicketsStats;
import com.epam.spring.core.domain.stats.GettingEventsStats;
import com.epam.spring.core.domain.stats.GettingTicketPriceStats;
import com.epam.spring.core.services.StatsService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private StatsService statsService;

    @Pointcut("execution(com.epam.spring.core.domain.entities.Event com.epam.spring.core.services.EventService+.getById(Integer))")
    private void gettingEvent() {}

    @Pointcut("execution(float com.epam.spring.core.services.BookingService+.getTicketPrice(com.epam.spring.core.domain.entities.User, Integer, Integer))")
    private void gettingTicketPrice() {}

    @Pointcut("execution(java.util.List<com.epam.spring.core.domain.entities.Ticket> com.epam.spring.core.services.BookingService+.bookTickets(com.epam.spring.core.domain.entities.User, Integer, java.util.List<Integer>))")
    private void bookingTickets() {}

    @AfterReturning(pointcut = "gettingEvent()", returning = "retVal")
    public void countGettingEvent(JoinPoint joinPoint, Object retVal) {
        Integer eventId = (Integer) joinPoint.getArgs()[0];
        if (eventId != null && retVal != null) {
            //Integer currentCounterValue = gettingEventStatistics.get(eventId);
            //gettingEventStatistics.put(eventId, currentCounterValue == null ? 1 : currentCounterValue + 1);
            GettingEventsStats gettingEventStats = statsService.getGettingEventStats(eventId);
            if (gettingEventStats == null) {
                statsService.createGettingEventCounter(eventId);
            } else {
                statsService.updateGettingEventCounter(eventId);
            }
        }
    }

    @Before("gettingTicketPrice()")
    public void countGettingTicketPriceForEvent(JoinPoint joinPoint) {
        Integer eventId = (Integer) joinPoint.getArgs()[1];
        if (eventId != null) {
            //Integer currentCounterValue = gettingTicketPriceForEventStatistics.get(eventId);
            //gettingTicketPriceForEventStatistics.put(eventId, currentCounterValue == null ? 1 : currentCounterValue + 1);
            GettingTicketPriceStats gettingTicketPriceStats = statsService.getGettingTicketPriceStats(eventId);
            if (gettingTicketPriceStats == null) {
                statsService.createGettingTicketPriceCounter(eventId);
            } else {
                statsService.updateGettingTicketPriceCounter(eventId);
            }
        }
    }

    @After("bookingTickets()")
    public void countBookingTicketsForEvent(JoinPoint joinPoint) {
        Integer eventId = (Integer) joinPoint.getArgs()[1];
        List<Integer> tickets = (List<Integer>) joinPoint.getArgs()[2];
        if (eventId != null && tickets != null) {
            int ticketsAmount = tickets.size();
            /*Integer currentCounterValue = bookingTicketsForEventStatistics.get(eventId);
            bookingTicketsForEventStatistics.put(eventId,
                    currentCounterValue == null ? ticketsAmount : currentCounterValue + ticketsAmount);*/
            BookingTicketsStats bookingTicketsStats = statsService.getBookingTicketsStats(eventId);
            if (bookingTicketsStats == null) {
                statsService.createBookingTicketsCounter(eventId, ticketsAmount);
            } else {
                statsService.updateBookingTicketsCounter(eventId, ticketsAmount);
            }
        }
    }

}
