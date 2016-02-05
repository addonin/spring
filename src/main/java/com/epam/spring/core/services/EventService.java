package com.epam.spring.core.services;

import com.epam.spring.core.domain.Event;
import com.epam.spring.core.domain.Auditorium;

import java.time.Instant;
import java.util.List;

/**
 * @author Dmytro_Adonin
 * @since 2/5/2016.
 */
public interface EventService {

    void create(Event event);

    void remove(Event event);

    Event getByName();

    List<Event> getAll();

    List<Event> getForDateRange(Instant from, Instant to);

    List<Event> getEventsTo(Instant to);

    void assignAuditorium(Event event, Auditorium auditorium, Instant date);

}
