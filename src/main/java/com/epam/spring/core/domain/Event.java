package com.epam.spring.core.domain;

import java.time.Instant;
import java.util.Set;

/**
 * @author Dmytro_Adonin
 * @since 2/5/2016.
 */
public class Event {

    private Integer id;
    private Movie movie;
    private Auditorium auditorium;
    private Instant startDateTime;
    private Set<Ticket> tickets;

    public Event(Movie movie) {
        this.movie = movie;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Auditorium getAuditorium() {
        return auditorium;
    }

    public void setAuditorium(Auditorium auditorium) {
        this.auditorium = auditorium;
    }

    public Instant getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(Instant startDateTime) {
        this.startDateTime = startDateTime;
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }
}
