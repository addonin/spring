package com.epam.spring.core.services;

import com.epam.spring.core.domain.entities.Ticket;
import com.epam.spring.core.domain.entities.User;

import java.util.List;

/**
 * @author Dmytro_Adonin
 * @since 2/5/2016.
 */
public interface UserService {

    Integer register(User user);

    void update(User user);

    boolean remove(Integer userId);

    User getById(Integer id);

    User getUserByEmail(String email);

    List<User> getUsersByName(String name);

    List<Ticket> getBookedTickets(Integer userId);

}
