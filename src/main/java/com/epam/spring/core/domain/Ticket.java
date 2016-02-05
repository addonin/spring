package com.epam.spring.core.domain;

import com.epam.spring.core.domain.enums.TicketState;

/**
 * @author Dmytro_Adonin
 * @since 2/5/2016.
 */
public class Ticket {

    private TicketState state;

    public TicketState getState() {
        return state;
    }

    public void setState(TicketState state) {
        this.state = state;
    }
}
