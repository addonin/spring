package com.epam.spring.core.dao.impl;

import com.epam.spring.core.domain.Ticket;
import com.epam.spring.core.domain.User;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.epam.spring.core.domain.enums.UserRole.CLIENT;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author dimon
 * @since 06/02/16.
 */
public class SimpleUserDaoTest {

    private User user;

    private SimpleUserDao dao = new SimpleUserDao();

    @Before
    public void setUp() throws Exception {
        user = new User();
        user.setName("name");
        user.setEmail("user@localhost");
        user.setRole(CLIENT);
    }

    @Test
    public void shouldRegisterUser() throws Exception {

        Integer id = dao.register(user);
        user.setId(id);

        User result = dao.getById(id);

        assertEquals("Registered user should exists", user, result);
    }

    @Test
    public void shouldRemoveUser() throws Exception {

        Integer id = dao.register(user);

        boolean removed = dao.remove(id);

        assertTrue("User shouldn't be exist", removed);
    }

    @Test
    public void shouldGetUserById() throws Exception {
        shouldRegisterUser();
    }

    @Test
    public void shouldGetUserByEmail() throws Exception {

        user.setId(dao.register(user));

        User result = dao.getUserByEmail(user.getEmail());

        assertEquals("Should exists", user, result);
    }

    @Test
    public void shouldGetUserByName() throws Exception {

        user.setId(dao.register(user));

        List<User> result = dao.getUserByName(user.getName());

        assertTrue("Should exists", result.contains(user));
    }

    @Test
    public void shouldGetUserTickets() throws Exception {

        List<Ticket> tickets = new ArrayList<>(Collections.singletonList(new Ticket()));
        user.setTickets(tickets);
        Integer id = dao.register(user);

        List<Ticket> result = dao.getBookedTickets(id);

        assertEquals("Tickets lists differs", tickets, result);
    }
}