package com.epam.spring.core.services.impl;

import com.epam.spring.core.dao.BookingDao;
import com.epam.spring.core.domain.entities.Event;
import com.epam.spring.core.domain.entities.Ticket;
import com.epam.spring.core.domain.entities.User;
import com.epam.spring.core.domain.enums.MovieRating;
import com.epam.spring.core.domain.enums.TicketState;
import com.epam.spring.core.services.BookingService;
import com.epam.spring.core.services.DiscountService;
import com.epam.spring.core.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Dmytro_Adonin
 * @since 2/5/2016.
 */
@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private EventService eventService;

    @Autowired
    private DiscountService discountService;

    @Autowired
    private BookingDao bookingDao;

    @Override
    @Transactional
    public float getTicketPrice(User watcher, Integer eventId, Integer seat) {
        float total = 0;
        Event event = eventService.getById(eventId);
        float discount = discountService.getDiscount(watcher, event);

        Float basePrice = event.getMovie().getBasePrice();
        //TODO should be replaced with another "anti-discount" strategy
        if (event.getAuditorium().getVipSeats().contains(seat)) {
            total += basePrice;
        }
        if (event.getMovie().getRating() == MovieRating.HIGH) {
            total += 0.2 * basePrice;
        }
        total += basePrice - discount;

        return total;
    }

    @Override
    @Transactional
    public List<Ticket> bookTickets(User watcher, Integer eventId, List<Integer> places) {
        List<Ticket> bookedTickets = new ArrayList<>();
        Event event = eventService.getById(eventId);
        for (Integer place : places) {
            List<Ticket> tickets = event.getTickets();
            tickets.stream().filter(ticket -> ticket.getSeat().getNumber() == place).forEach(ticket -> {
                ticket.setUser(watcher);
                ticket.setState(TicketState.SOLD);
                bookingDao.update(ticket);
                bookedTickets.add(ticket);
            });
        }
        return bookedTickets;
    }

    @Override
    @Transactional
    public List<Ticket> getSoldTicketsForEvent(Integer eventId) {
        return eventService.getById(eventId).getTickets().stream()
                .filter(ticket -> ticket.getState() == TicketState.SOLD)
                .collect(Collectors.toList());
    }
}
