package com.epam.spring.core.services.impl;

import com.epam.spring.core.dao.StatsDao;
import com.epam.spring.core.domain.stats.BookingTicketsStats;
import com.epam.spring.core.domain.stats.DiscountsPerUserStats;
import com.epam.spring.core.domain.stats.GettingEventsStats;
import com.epam.spring.core.domain.stats.GettingTicketPriceStats;
import com.epam.spring.core.services.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Dmytro_Adonin
 * @since 2/23/2016.
 */
@Service
public class StatsServiceImpl implements StatsService {

    @Autowired
    @Qualifier("hibernateStatsDao")
    private StatsDao statsDao;

    @Override
    @Transactional
    public GettingEventsStats getGettingEventStats(Integer id) {
        return statsDao.getGettingEventStats(id);
    }

    @Override
    @Transactional
    public void createGettingEventCounter(Integer id) {
        statsDao.createGettingEventCounter(id);
    }

    @Override
    @Transactional
    public void updateGettingEventCounter(Integer id) {
        statsDao.updateGettingEventCounter(id);
    }

    @Override
    public GettingTicketPriceStats getGettingTicketPriceStats(Integer id) {
        return statsDao.getGettingTicketPriceStats(id);
    }

    @Override
    public void createGettingTicketPriceCounter(Integer id) {
        statsDao.createGettingTicketPriceCounter(id);
    }

    @Override
    public void updateGettingTicketPriceCounter(Integer id) {
        statsDao.updateGettingTicketPriceCounter(id);
    }

    @Override
    public BookingTicketsStats getBookingTicketsStats(Integer eventId) {
        return statsDao.getBookingTicketsStats(eventId);
    }

    @Override
    public void createBookingTicketsCounter(Integer eventId, int ticketsAmount) {
        statsDao.createBookingTicketsCounter(eventId, ticketsAmount);
    }

    @Override
    public void updateBookingTicketsCounter(Integer eventId, int ticketsAmount) {
        statsDao.updateBookingTicketsCounter(eventId, ticketsAmount);
    }

    @Override
    public DiscountsPerUserStats getDiscountsPerUserStats(Integer userId) {
        return statsDao.getDiscountsPerUserStats(userId);
    }

    @Override
    public void createDicountsPerUserCounter(Integer userId) {
        statsDao.createDicountsPerUserCounter(userId);
    }

    @Override
    public void updateDicountsPerUserCounter(Integer userId) {
        statsDao.updateDicountsPerUserCounter(userId);
    }

}
