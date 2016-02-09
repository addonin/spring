package com.epam.spring.core.services.impl;

import com.epam.spring.core.context.TestCoreApplicationContext;
import com.epam.spring.core.dao.EventDao;
import com.epam.spring.core.domain.Event;
import com.epam.spring.core.domain.Movie;
import com.epam.spring.core.domain.enums.MovieRating;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * @author dimon
 * @since 07/02/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestCoreApplicationContext.class})
public class EventServiceImplTest {

    private Movie movie;
    private Event event;

    @Autowired
    private EventDao eventDaoMock;

    @InjectMocks
    private EventServiceImpl eventService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        movie = new Movie();
        movie.setName("name");
        movie.setBasePrice(10.25F);
        movie.setRating(MovieRating.MID);
        event = new Event(movie);
    }

    @Test
    public void shouldCreateEvent() throws Exception {

        doReturn(1).when(eventDaoMock).create(movie);

        Integer id = eventService.create(movie);

        assertNotNull("Id shouldn't be a null", id);
        verify(eventDaoMock, times(1)).create(movie);
    }

    @Test
    public void shouldRemoveUser() throws Exception {

        Integer id = 1;
        doReturn(true).when(eventDaoMock).remove(id);

        boolean removed = eventService.remove(id);

        assertTrue("Event with id " + id + " have to be removed", removed);
        verify(eventDaoMock, times(1)).remove(id);
    }

    @Test
    public void shouldReturnEventById() throws Exception {

        Integer id = event.getId();
        doReturn(event).when(eventDaoMock).getById(id);

        Event result = eventService.getById(id);

        assertEquals("Unexpected event have been got", event, result);
        verify(eventDaoMock, times(1)).getById(id);
    }

    @Test
    public void shouldReturnAllEvents() throws Exception {

        ArrayList<Event> events = new ArrayList<>(Collections.singletonList(event));
        doReturn(events).when(eventDaoMock).getAll();

        List<Event> result = eventService.getAll();

        assertTrue("Events should contain result", events.containsAll(result));
        verify(eventDaoMock, times(1)).getAll();
    }
}