package com.epam.spring.core.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Dmytro_Adonin
 * @since 2/5/2016.
 */
@Entity
public class Event {

    @Id
    @GeneratedValue
    private Integer id;
    @OneToOne
    private Movie movie;
    @Embedded
    private Auditorium auditorium;
    private LocalDateTime startDateTime;
    @OneToMany
    private Set<Ticket> tickets = new HashSet<>();

    public Event(Movie movie) {
        this.movie = movie;
    }

    public Event() {
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

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;

        if (id != null ? !id.equals(event.id) : event.id != null) return false;
        if (movie != null ? !movie.equals(event.movie) : event.movie != null) return false;
        if (auditorium != null ? !auditorium.equals(event.auditorium) : event.auditorium != null) return false;
        if (startDateTime != null ? !startDateTime.equals(event.startDateTime) : event.startDateTime != null)
            return false;
        return tickets != null ? tickets.equals(event.tickets) : event.tickets == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (movie != null ? movie.hashCode() : 0);
        result = 31 * result + (auditorium != null ? auditorium.hashCode() : 0);
        result = 31 * result + (startDateTime != null ? startDateTime.hashCode() : 0);
        result = 31 * result + (tickets != null ? tickets.hashCode() : 0);
        return result;
    }
}

