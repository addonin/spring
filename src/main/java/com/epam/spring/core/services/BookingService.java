package com.epam.spring.core.services;

import com.epam.spring.core.domain.entities.Ticket;
import com.epam.spring.core.domain.entities.User;

import java.util.List;

/**
 * @author Dmytro_Adonin
 * @since 2/5/2016.
 */
public interface BookingService {

    float getTicketPrice(User watcher, Integer eventId, Integer seat);

    List<Ticket> bookTickets(User watcher, Integer eventId, List<Integer> places);

    List<Ticket> getSoldTicketsForEvent(Integer eventId);

}
