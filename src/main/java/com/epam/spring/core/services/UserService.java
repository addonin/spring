package com.epam.spring.core.services;

import com.epam.spring.core.domain.User;
import sun.security.krb5.internal.Ticket;

import java.util.List;

/**
 * Created by Dmytro_Adonin on 2/5/2016.
 */
public interface UserService {

    void register(User user);

    void remove(Integer userId);

    User getById(Integer id);

    User getUserByEmail(String email);

    List<User> getUsersByName(String name);

    List<Ticket> getBookedTickets(Integer userId);

}
