package com.epam.spring.core.dao;

import com.epam.spring.core.domain.stats.BookingTicketsStats;
import com.epam.spring.core.domain.stats.DiscountsPerUserStats;
import com.epam.spring.core.domain.stats.GettingEventsStats;
import com.epam.spring.core.domain.stats.GettingTicketPriceStats;

/**
 * @author Dmytro_Adonin
 * @since 2/23/2016.
 */
public interface StatsDao {

    GettingEventsStats getGettingEventStats(Integer eventId);

    void createGettingEventCounter(Integer id);

    void updateGettingEventCounter(Integer id);

    GettingTicketPriceStats getGettingTicketPriceStats(Integer id);

    void createGettingTicketPriceCounter(Integer id);

    void updateGettingTicketPriceCounter(Integer id);

    BookingTicketsStats getBookingTicketsStats(Integer eventId);

    void createBookingTicketsCounter(Integer eventId, int ticketsAmount);

    void updateBookingTicketsCounter(Integer eventId, int ticketsAmount);

    DiscountsPerUserStats getDiscountsPerUserStats(Integer userId);

    void createDicountsPerUserCounter(Integer userId);

    void updateDicountsPerUserCounter(Integer userId);

}
