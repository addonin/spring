package com.epam.spring.core.services.impl;

import com.epam.spring.core.dao.UserDao;
import com.epam.spring.core.domain.User;
import com.epam.spring.core.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.security.krb5.internal.Ticket;

import java.util.List;

/**
 * @author Dmytro_Adonin
 * @since 2/5/2016.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public Integer register(User user) {
        return userDao.register(user);
    }

    public void remove(Integer userId) {

    }

    public User getById(Integer id) {
        return null;
    }

    public User getUserByEmail(String email) {
        return null;
    }

    public List<User> getUsersByName(String name) {
        return null;
    }

    public List<Ticket> getBookedTickets(Integer userId) {
        return null;
    }

}
