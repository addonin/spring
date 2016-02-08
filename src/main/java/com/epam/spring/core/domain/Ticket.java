package com.epam.spring.core.domain;

import com.epam.spring.core.domain.enums.TicketState;

/**
 * @author Dmytro_Adonin
 * @since 2/5/2016.
 */
public class Ticket {

    private Integer id;
    private Event event;
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
}
