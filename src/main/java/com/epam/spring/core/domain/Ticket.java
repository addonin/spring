package com.epam.spring.core.domain;

import com.epam.spring.core.domain.enums.TicketState;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;

/**
 * @author Dmytro_Adonin
 * @since 2/5/2016.
 */
@Embeddable
public class Ticket {

    private Integer id;
    private Integer eventId;
    private Integer clientId;
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

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
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
        if (eventId != null ? !eventId.equals(ticket.eventId) : ticket.eventId != null) return false;
        if (clientId != null ? !clientId.equals(ticket.clientId) : ticket.clientId != null) return false;
        if (seat != null ? !seat.equals(ticket.seat) : ticket.seat != null) return false;
        if (state != ticket.state) return false;
        return price != null ? price.equals(ticket.price) : ticket.price == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (eventId != null ? eventId.hashCode() : 0);
        result = 31 * result + (clientId != null ? clientId.hashCode() : 0);
        result = 31 * result + (seat != null ? seat.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }
}
