package com.epam.spring.core.services;

import com.epam.spring.core.domain.Ticket;
import com.epam.spring.core.domain.User;

import java.util.List;

/**
 * @author Dmytro_Adonin
 * @since 2/5/2016.
 */
public interface UserService {

    Integer register(User user);

    boolean remove(Integer userId);

    User getById(Integer id);

    User getUserByEmail(String email);

    List<User> getUsersByName(String name);

    List<Ticket> getBookedTickets(Integer userId);

}
