package com.epam.spring.core.services;

import com.epam.spring.core.domain.stats.BookingTicketsStats;
import com.epam.spring.core.domain.stats.DiscountsPerUserStats;
import com.epam.spring.core.domain.stats.GettingEventsStats;
import com.epam.spring.core.domain.stats.GettingTicketPriceStats;

/**
 * @author Dmytro_Adonin
 * @since 2/23/2016.
 */
public interface StatsService {

    GettingEventsStats getGettingEventStats(Integer eventId);

    void createGettingEventCounter(Integer eventId);

    void updateGettingEventCounter(Integer eventId);

    GettingTicketPriceStats getGettingTicketPriceStats(Integer eventId);

    void createGettingTicketPriceCounter(Integer eventId);

    void updateGettingTicketPriceCounter(Integer eventId);

    BookingTicketsStats getBookingTicketsStats(Integer eventId);

    void createBookingTicketsCounter(Integer eventId, int ticketsAmount);

    void updateBookingTicketsCounter(Integer eventId, int ticketsAmount);

    DiscountsPerUserStats getDiscountsPerUserStats(Integer userId);

    void createDicountsPerUserCounter(Integer userId);

    void updateDicountsPerUserCounter(Integer userId);
}
