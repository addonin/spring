package com.epam.spring.core.dao.impl;

import com.epam.spring.core.dao.EventDao;
import com.epam.spring.core.domain.entities.Event;
import com.epam.spring.core.domain.entities.Movie;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Dmytro_Adonin
 * @since 2/5/2016.
 */
@Repository
public class SimpleEventDao implements EventDao {

    private volatile int counter;

    private Map<Integer, Event> events = new HashMap<>();

    @Override
    public Integer create(Movie movie) {
        Event event = new Event(movie);
        int id = generateId();
        event.setId(id);
        events.put(id, event);
        return id;
    }

    @Override
    public boolean remove(Integer eventId) {
        return events.remove(eventId, events.get(eventId));
    }

    @Override
    public void update(Event event) {
    }

    @Override
    public Event getById(Integer eventId) {
        return events.get(eventId);
    }

    @Override
    public List<Event> getAll() {
        return new ArrayList<>(events.values());
    }

    private int generateId() {
        return ++counter;
    }

}
