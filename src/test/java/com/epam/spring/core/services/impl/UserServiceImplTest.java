package com.epam.spring.core.services.impl;

import com.epam.spring.core.context.CoreApplicationContext;
import com.epam.spring.core.context.TestCoreApplicationContext;
import com.epam.spring.core.dao.UserDao;
import com.epam.spring.core.domain.User;
import com.epam.spring.core.domain.enums.UserRole;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.doReturn;

/**
 * @author Dmytro_Adonin
 * @since 2/5/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {CoreApplicationContext.class, TestCoreApplicationContext.class})
public class UserServiceImplTest {

    private User user;

    @Mock
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
    }

    @Test
    public void testRemove() throws Exception {

    }

    @Test
    public void testGetById() throws Exception {

    }

    @Test
    public void testGetUserByEmail() throws Exception {

    }

    @Test
    public void testGetUsersByName() throws Exception {

    }

    @Test
    public void testGetBookedTickets() throws Exception {

    }
}