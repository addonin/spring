package com.epam.spring.core.dao;

import com.epam.spring.core.domain.entities.Event;
import com.epam.spring.core.domain.entities.Movie;

import java.util.List;

/**
 * @author Dmytro_Adonin
 * @since 2/5/2016.
 */
public interface EventDao {

    Integer create(Movie movie);

    boolean remove(Integer eventId);

    void update(Event event);

    Event getById(Integer eventId);

    List<Event> getAll();

}
