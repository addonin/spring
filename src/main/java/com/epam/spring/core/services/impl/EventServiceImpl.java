package com.epam.spring.core.services.impl;

import com.epam.spring.core.dao.BookingDao;
import com.epam.spring.core.dao.EventDao;
import com.epam.spring.core.domain.*;
import com.epam.spring.core.domain.enums.SeatStatus;
import com.epam.spring.core.domain.enums.TicketState;
import com.epam.spring.core.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Dmytro_Adonin
 * @since 2/5/2016.
 */
@Service
public class EventServiceImpl implements EventService {

    @Autowired
    @Qualifier("hibernateEventDao")
    private EventDao eventDao;

    @Autowired
    @Qualifier("hibernateBookingDao")
    private BookingDao bookingDao;

    @Override
    @Transactional
    public Integer create(Movie movie) {
        return eventDao.create(movie);
    }

    @Override
    @Transactional
    public boolean remove(Integer eventId) {
        return eventDao.remove(eventId);
    }

    @Override
    @Transactional
    public Event getById(Integer eventId) {
        return eventDao.getById(eventId);
    }

    @Override
    @Transactional
    public List<Event> getAll() {
        return eventDao.getAll();
    }

    @Override
    @Transactional
    public boolean assignAuditorium(Integer eventId, Auditorium auditorium, LocalDateTime datetime) {
        for (Event event : getAll()) {
            if (auditorium.equals(event.getAuditorium()) && intersectsWithAnotherEvent(event, datetime)) {
                return false;
            }
        }
        Event currentEvent = getById(eventId);
        currentEvent.setAuditorium(auditorium);
        currentEvent.setStartDateTime(datetime);
        setTickets(currentEvent, auditorium);
        return true;
    }

    private boolean intersectsWithAnotherEvent(Event event, LocalDateTime toCheck) {
        LocalDateTime start = event.getStartDateTime();
        Duration duration = event.getMovie().getDuration();
        LocalDateTime end = start.plus(duration);
        return !toCheck.isBefore(start) && !toCheck.isAfter(end);
    }

    private void setTickets(Event currentEvent, Auditorium auditorium) {
        List<Ticket> tickets = currentEvent.getTickets();
        Integer seatsNumber = auditorium.getSeatsNumber();
        List<Integer> vipSeats = auditorium.getVipSeats();
        for (int i = 1; i <= seatsNumber; i++) {
            Ticket ticket = new Ticket();
            ticket.setEvent(currentEvent);
            ticket.setState(TicketState.FREE);
            ticket.setSeat(new Seat(i, vipSeats.contains(i) ? SeatStatus.VIP : SeatStatus.STANDARD));
            tickets.add(ticket);
            bookingDao.create(ticket);
            //eventDao.update(currentEvent);
        }

    }

}
