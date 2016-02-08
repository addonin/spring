package com.epam.spring.core.services;

import com.epam.spring.core.domain.Ticket;
import com.epam.spring.core.domain.User;

import java.util.List;

/**
 * @author Dmytro_Adonin
 * @since 2/5/2016.
 */
public interface BookingService {

    float getTicketPrice(Integer eventId, List<Integer>seats, User watcher);

    void bookTicket(User watcher, Ticket ticket);

    List<Ticket> getTicketsForEvent(Integer eventId);

}
