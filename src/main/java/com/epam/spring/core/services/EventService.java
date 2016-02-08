package com.epam.spring.core.services;

import com.epam.spring.core.domain.Auditorium;
import com.epam.spring.core.domain.Event;
import com.epam.spring.core.domain.Movie;

import java.time.Instant;
import java.util.List;

/**
 * @author Dmytro_Adonin
 * @since 2/5/2016.
 */
public interface EventService {

    Integer create(Movie movie);

    boolean remove(Integer eventId);

    Event getById(Integer eventId);

    List<Event> getAll();

    //List<Event> getForDateRange(Instant from, Instant to);

    //List<Event> getEventsTo(Instant to);

    boolean assignAuditorium(Integer eventId, Auditorium auditorium, Instant datetime);

}
