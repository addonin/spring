package com.epam.spring.core.services.impl;

import com.epam.spring.core.dao.UserDao;
import com.epam.spring.core.domain.Ticket;
import com.epam.spring.core.domain.User;
import com.epam.spring.core.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Dmytro_Adonin
 * @since 2/5/2016.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public Integer register(User user) {
        return userDao.register(user);
    }

    @Override
    public boolean remove(Integer userId) {
        return userDao.remove(userId);
    }

    @Override
    public User getById(Integer id) {
        return userDao.getById(id);
    }

    @Override
    public User getUserByEmail(String email) {
        return userDao.getUserByEmail(email);
    }

    @Override
    public List<User> getUsersByName(String name) {
        return userDao.getUserByName(name);
    }

    @Override
    public List<Ticket> getBookedTickets(Integer userId) {
        return userDao.getBookedTickets(userId);
    }

}
