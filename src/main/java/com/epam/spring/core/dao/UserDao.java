package com.epam.spring.core.dao;

import com.epam.spring.core.domain.Ticket;
import com.epam.spring.core.domain.User;

import java.util.List;

/**
 * @author Dmytro_Adonin
 * @since 2/5/2016.
 */
public interface UserDao {

    Integer register(User user);

    void update(User user);

    boolean remove(Integer userId);

    User getById(Integer userId);

    User getUserByEmail(String email);

    List<User> getUserByName(String name);

    List<Ticket> getBookedTickets(Integer userId);
}
