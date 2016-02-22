package com.epam.spring.core.domain;

import com.epam.spring.core.domain.enums.TicketState;

import javax.persistence.*;

/**
 * @author Dmytro_Adonin
 * @since 2/5/2016.
 */
@Entity
public class Ticket {

    @Id
    @GeneratedValue
    private Integer id;
    @ManyToOne
    private Event event;
    @OneToOne
    private User user;
    @Embedded
    private Seat seat;
    private TicketState state;
    private Float price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public TicketState getState() {
        return state;
    }

    public void setState(TicketState state) {
        this.state = state;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ticket ticket = (Ticket) o;

        if (id != null ? !id.equals(ticket.id) : ticket.id != null) return false;
        if (event != null ? !event.equals(ticket.event) : ticket.event != null) return false;
        if (user != null ? !user.equals(ticket.user) : ticket.user != null) return false;
        if (seat != null ? !seat.equals(ticket.seat) : ticket.seat != null) return false;
        if (state != ticket.state) return false;
        return price != null ? price.equals(ticket.price) : ticket.price == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (event != null ? event.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (seat != null ? seat.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }
}
