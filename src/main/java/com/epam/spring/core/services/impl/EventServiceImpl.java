package com.epam.spring.core.services.impl;

import com.epam.spring.core.dao.EventDao;
import com.epam.spring.core.domain.Auditorium;
import com.epam.spring.core.domain.Event;
import com.epam.spring.core.domain.Movie;
import com.epam.spring.core.services.AuditoriumService;
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
    private AuditoriumService auditoriumService;

    @Autowired
    private EventDao eventDao;

    @Override
    public Integer create(Movie movie) {
        return eventDao.create(movie);
    }

    @Override
    public boolean remove(Integer eventId) {
        return eventDao.remove(eventId);
    }

    @Override
    public Event getById(Integer eventId) {
        return eventDao.getById(eventId);
    }

    @Override
    public List<Event> getAll() {
        return eventDao.getAll();
    }

    @Override
    public boolean assignAuditorium(Integer eventId, Auditorium auditorium, Instant datetime) {
        for (Event event : getAll()) {
            if (auditorium.equals(event.getAuditorium())
                    //&& Period.event.getStartDateTime(). + event.getMovie().getDuration()
            ) {
                return false;
            }
        }
        Event currentEvent = getById(eventId);
        currentEvent.setAuditorium(auditorium);
        currentEvent.setStartDateTime(datetime);
        return true;
    }

}
