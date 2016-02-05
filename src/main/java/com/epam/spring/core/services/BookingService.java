package com.epam.spring.core.services;

import com.epam.spring.core.domain.Event;
import com.epam.spring.core.domain.Ticket;
import com.epam.spring.core.domain.User;

import java.time.Instant;
import java.util.List;

/**
 * @author Dmytro_Adonin
 * @since 2/5/2016.
 */
public interface BookingService {

    float getTicketPrice(Event event, Instant datetime, List<Integer>seats, User watcher);

    void bookTicket(User watcher, Ticket ticket);

    List<Ticket> getTicketsForEvent(Event event, Instant datetime);

}
