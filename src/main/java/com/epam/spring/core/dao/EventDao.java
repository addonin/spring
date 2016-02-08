package com.epam.spring.core.dao;

import com.epam.spring.core.domain.Event;

import java.util.List;

/**
 * @author Dmytro_Adonin
 * @since 2/5/2016.
 */
public interface EventDao {

    Integer create(Event event);

    boolean remove(Integer eventId);

    Event getById(Integer eventId);

    List<Event> getAll();

}
