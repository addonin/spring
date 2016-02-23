package com.epam.spring.core.dao.impl;

import com.epam.spring.core.dao.BookingDao;
import com.epam.spring.core.domain.entities.Ticket;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author Dmytro_Adonin
 * @since 2/22/2016.
 */
@Repository
public class HibernateBookingDao implements BookingDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Integer create(Ticket ticket) {
        return (Integer) sessionFactory.getCurrentSession().save(ticket);
    }

    @Override
    public void update(Ticket ticket) {
        sessionFactory.getCurrentSession().update(ticket);
    }
}
