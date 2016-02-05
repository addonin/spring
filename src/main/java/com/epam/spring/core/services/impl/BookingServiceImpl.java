package com.epam.spring.core.services.impl;

import com.epam.spring.core.dao.BookingDao;
import com.epam.spring.core.domain.Event;
import com.epam.spring.core.domain.Ticket;
import com.epam.spring.core.domain.User;
import com.epam.spring.core.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

/**
 * @author Dmytro_Adonin
 * @since 2/5/2016.
 */
@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingDao dao;

    public float getTicketPrice(Event event, Instant datetime, List<Integer> seats, User watcher) {
        return 0;
    }

    public void bookTicket(User watcher, Ticket ticket) {

    }

    public List<Ticket> getTicketsForEvent(Event event, Instant datetime) {
        return null;
    }
}
