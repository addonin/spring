package com.epam.spring.core.dao.impl;

import com.epam.spring.core.dao.EventDao;
import com.epam.spring.core.domain.Event;
import com.epam.spring.core.domain.Movie;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Dmytro_Adonin
 * @since 2/22/2016.
 */
@Repository
public class HibernateEventDao implements EventDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Integer create(Movie movie) {
        sessionFactory.getCurrentSession().save(movie);
        return (Integer) sessionFactory.getCurrentSession().save(new Event(movie));
    }

    @Override
    public void update(Event event) {
        sessionFactory.getCurrentSession().update(event);
    }

    @Override
    public boolean remove(Integer eventId) {
        Event event = getById(eventId);
        if (event != null) {
            sessionFactory.getCurrentSession().delete(event);
            return true;
        }
        return false;
    }

    @Override
    public Event getById(Integer eventId) {
        return sessionFactory.getCurrentSession().get(Event.class, eventId);
    }

    @Override
    public List<Event> getAll() {
        return sessionFactory.getCurrentSession().createCriteria(Event.class).list();
    }
}
