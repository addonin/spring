package com.epam.spring.core.services.impl;

import com.epam.spring.core.dao.BookingDao;
import com.epam.spring.core.domain.Event;
import com.epam.spring.core.domain.Ticket;
import com.epam.spring.core.domain.User;
import com.epam.spring.core.domain.enums.MovieRating;
import com.epam.spring.core.domain.enums.TicketState;
import com.epam.spring.core.services.BookingService;
import com.epam.spring.core.services.DiscountService;
import com.epam.spring.core.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public float getTicketPrice(Integer eventId, List<Integer> seats, User watcher) {
        float total = 0;
        Event event = eventService.getById(eventId);
        float discount = discountService.getDiscount(watcher, event);
        for (Integer seat : seats) {
            Float basePrice = event.getMovie().getBasePrice();
            //TODO should be replaced with another "anti-discount" strategy
            if (event.getAuditorium().getVipSeats().contains(seat)) {
                total += basePrice;
            }
            if (event.getMovie().getRating() == MovieRating.HIGH) {
                total += 0.2 * basePrice;
            }
            total += basePrice - discount;
        }
        return total;
    }

    public void bookTicket(User watcher, Ticket ticket) {

    }

    public List<Ticket> getTicketsForEvent(Integer eventId) {
        return eventService.getById(eventId).getTickets().stream()
                .filter(ticket -> ticket.getState() == TicketState.SOLD)
                .collect(Collectors.toList());
    }
}
