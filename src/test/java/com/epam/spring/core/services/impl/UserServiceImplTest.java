package com.epam.spring.core.services.impl;

import com.epam.spring.core.context.TestCoreApplicationContext;
import com.epam.spring.core.dao.UserDao;
import com.epam.spring.core.domain.Ticket;
import com.epam.spring.core.domain.User;
import com.epam.spring.core.domain.enums.UserRole;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * @author Dmytro_Adonin
 * @since 2/5/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestCoreApplicationContext.class})
public class UserServiceImplTest {

    private User user;

    @Autowired
    private UserDao userDaoMock;

    @InjectMocks
    private UserServiceImpl userService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        user = new User();
        user.setName("username");
        user.setEmail("username@localhost");
        user.setRole(UserRole.CLIENT);
    }

    @Test
    public void shouldRegisterUser() throws Exception {

        doReturn(1).when(userDaoMock).register(user);

        Integer id = userService.register(user);

        assertNotNull("Id shouldn't be a null", id);
        verify(userDaoMock, times(1)).register(user);
    }

    @Test
    public void shouldRemoveUser() throws Exception {

        Integer id = 1;
        doReturn(true).when(userDaoMock).remove(id);

        boolean removed = userService.remove(id);

        assertTrue("User with id " + id + " have to be removed", removed);
        verify(userDaoMock, times(1)).remove(id);
    }

    @Test
    public void testGetById() throws Exception {

        Integer id = 1;
        doReturn(user).when(userDaoMock).getById(id);

        User result = userService.getById(id);

        assertEquals("Unexpected user have been got", user, result);
        verify(userDaoMock, times(1)).getById(id);
    }

    @Test
    public void testGetUserByEmail() throws Exception {

        String email = user.getEmail();
        doReturn(user).when(userDaoMock).getUserByEmail(email);

        User result = userService.getUserByEmail(email);

        assertEquals("Unexpected user have been got", user, result);
        verify(userDaoMock, times(1)).getUserByEmail(email);
    }

    @Test
    public void testGetUsersByName() throws Exception {

        String name = user.getName();
        List<User> users = new ArrayList<>(Collections.singletonList(user));
        doReturn(users).when(userDaoMock).getUserByName(name);

        List<User> result = userService.getUsersByName(name);

        assertTrue("Should contain user with name " + name, users.containsAll(result));
        verify(userDaoMock, times(1)).getUserByName(name);
    }

    @Test
    public void testGetBookedTickets() throws Exception {

        Integer id = 1;
        user.setId(id);
        List<Ticket> tickets = new ArrayList<>(Collections.singletonList(new Ticket()));
        user.setTickets(tickets);
        doReturn(tickets).when(userDaoMock).getBookedTickets(id);

        List<Ticket> result = userService.getBookedTickets(id);

        assertTrue("Should contain tickets", tickets.containsAll(result));
        verify(userDaoMock, times(1)).getBookedTickets(id);
    }
}