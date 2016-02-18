package com.epam.spring.core.dao.impl;

import com.epam.spring.core.dao.UserDao;
import com.epam.spring.core.domain.Ticket;
import com.epam.spring.core.domain.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Dmytro_Adonin
 * @since 2/18/2016.
 */
@Repository
public class HibernateUserDao implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Integer register(User user) {
        return (Integer) sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public boolean remove(Integer userId) {
        return false;
    }

    @Override
    public User getById(Integer userId) {
        return sessionFactory.getCurrentSession().get(User.class, userId);
    }

    @Override
    public User getUserByEmail(String email) {
        return null;
    }

    @Override
    public List<User> getUserByName(String name) {
        return null;
    }

    @Override
    public List<Ticket> getBookedTickets(Integer userId) {
        return null;
    }
}
