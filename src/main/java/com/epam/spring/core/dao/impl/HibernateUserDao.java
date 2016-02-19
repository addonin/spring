package com.epam.spring.core.dao.impl;

import com.epam.spring.core.dao.UserDao;
import com.epam.spring.core.domain.Ticket;
import com.epam.spring.core.domain.User;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
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
    public void update(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    @Override
    public boolean remove(Integer userId) {
        User user = getById(userId);
        if (user != null) {
            sessionFactory.getCurrentSession().delete(user);
            return true;
        }
        return false;
    }

    @Override
    public User getById(Integer userId) {
        return sessionFactory.getCurrentSession().get(User.class, userId);
    }

    @Override
    public User getUserByEmail(String email) {
        //TODO ask about best practice
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
        return (User) criteria.add(Restrictions.eq("email", email)).uniqueResult();
    }

    @Override
    public List<User> getUserByName(String name) {
        //TODO ask about best practice
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
        return (List<User>) criteria.add(Restrictions.eq("name", name)).list();
    }

    @Override
    public List<Ticket> getBookedTickets(Integer userId) {
        User user = getById(userId);
        return user != null ? user.getTickets() : null;
    }
}
