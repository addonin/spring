package com.epam.spring.core.dao.impl;

import com.epam.spring.core.dao.StatsDao;
import com.epam.spring.core.domain.stats.BookingTicketsStats;
import com.epam.spring.core.domain.stats.DiscountsPerUserStats;
import com.epam.spring.core.domain.stats.GettingEventsStats;
import com.epam.spring.core.domain.stats.GettingTicketPriceStats;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author Dmytro_Adonin
 * @since 2/23/2016.
 */
@Repository
public class HibernateStatsDao implements StatsDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public GettingEventsStats getGettingEventStats(Integer eventId) {
        return sessionFactory.getCurrentSession().get(GettingEventsStats.class, eventId);
    }

    @Override
    public void createGettingEventCounter(Integer eventId) {
        GettingEventsStats gettingEventsStats = new GettingEventsStats();
        gettingEventsStats.setEventId(eventId);
        gettingEventsStats.setGettingCounter(1);
        sessionFactory.getCurrentSession().save(gettingEventsStats);
    }

    @Override
    public void updateGettingEventCounter(Integer eventId) {
        GettingEventsStats gettingEventStats = getGettingEventStats(eventId);
        gettingEventStats.setGettingCounter(gettingEventStats.getGettingCounter() + 1);
        sessionFactory.getCurrentSession().update(gettingEventStats);
    }

    @Override
    public GettingTicketPriceStats getGettingTicketPriceStats(Integer eventId) {
        return sessionFactory.getCurrentSession().get(GettingTicketPriceStats.class, eventId);
    }

    @Override
    public void createGettingTicketPriceCounter(Integer eventId) {
        GettingTicketPriceStats gettingTicketPriceStats = new GettingTicketPriceStats();
        gettingTicketPriceStats.setEventId(eventId);
        gettingTicketPriceStats.setGettingTicketPriceCounter(1);
        sessionFactory.getCurrentSession().save(gettingTicketPriceStats);
    }

    @Override
    public void updateGettingTicketPriceCounter(Integer eventId) {
        GettingTicketPriceStats gettingTicketPriceStats = getGettingTicketPriceStats(eventId);
        gettingTicketPriceStats.setGettingTicketPriceCounter(gettingTicketPriceStats.getGettingTicketPriceCounter() + 1);
        sessionFactory.getCurrentSession().update(gettingTicketPriceStats);
    }

    @Override
    public BookingTicketsStats getBookingTicketsStats(Integer eventId) {
        return sessionFactory.getCurrentSession().get(BookingTicketsStats.class, eventId);
    }

    @Override
    public void createBookingTicketsCounter(Integer eventId, int ticketsAmount) {
        BookingTicketsStats bookingTicketsStats = new BookingTicketsStats();
        bookingTicketsStats.setEventId(eventId);
        bookingTicketsStats.setBookingTicketsCounter(ticketsAmount);
        sessionFactory.getCurrentSession().save(bookingTicketsStats);
    }

    @Override
    public void updateBookingTicketsCounter(Integer eventId, int ticketsAmount) {
        BookingTicketsStats bookingTicketsStats = getBookingTicketsStats(eventId);
        bookingTicketsStats.setBookingTicketsCounter(bookingTicketsStats.getBookingTicketsCounter() + ticketsAmount);
        sessionFactory.getCurrentSession().update(bookingTicketsStats);
    }

    @Override
    public DiscountsPerUserStats getDiscountsPerUserStats(Integer userId) {
        return sessionFactory.getCurrentSession().get(DiscountsPerUserStats.class, userId);
    }

    @Override
    public void createDicountsPerUserCounter(Integer userId) {
        DiscountsPerUserStats discountsPerUserStats = new DiscountsPerUserStats();
        discountsPerUserStats.setUserId(userId);
        discountsPerUserStats.setDiscountTimesCounter(1);
        sessionFactory.getCurrentSession().save(discountsPerUserStats);
    }

    @Override
    public void updateDicountsPerUserCounter(Integer userId) {
        BookingTicketsStats bookingTicketsStats = getBookingTicketsStats(userId);
        bookingTicketsStats.setBookingTicketsCounter(bookingTicketsStats.getBookingTicketsCounter() + 1);
        sessionFactory.getCurrentSession().update(bookingTicketsStats);
    }

}
