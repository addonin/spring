package com.epam.spring.core.dao;

import com.epam.spring.core.domain.entities.Ticket;

/**
 * @author Dmytro_Adonin
 * @since 2/5/2016.
 */
public interface BookingDao {

    Integer create(Ticket ticket);

    void update(Ticket ticket);

}
