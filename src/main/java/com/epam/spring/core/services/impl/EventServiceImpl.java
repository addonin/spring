package com.epam.spring.core.services.impl;

import com.epam.spring.core.dao.EventDao;
import com.epam.spring.core.domain.Event;
import com.epam.spring.core.domain.Auditorium;
import com.epam.spring.core.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

/**
 * @author Dmytro_Adonin
 * @since 2/5/2016.
 */
@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventDao dao;

    public void create(Event event) {

    }

    public void remove(Event event) {

    }

    public Event getByName() {
        return null;
    }

    public List<Event> getAll() {
        return null;
    }

    public List<Event> getForDateRange(Instant from, Instant to) {
        return null;
    }

    public List<Event> getEventsTo(Instant to) {
        return null;
    }

    public void assignAuditorium(Event event, Auditorium auditorium, Instant date) {

    }
}
