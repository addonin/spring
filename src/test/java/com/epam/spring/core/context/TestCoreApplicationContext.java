package com.epam.spring.core.context;

import com.epam.spring.core.dao.EventDao;
import com.epam.spring.core.dao.UserDao;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Dmytro_Adonin
 * @since 2/5/2016.
 */
@Configuration
public class TestCoreApplicationContext {

    @Mock
    private UserDao userDaoMock;

    @Mock
    private EventDao eventDaoMock;

    public TestCoreApplicationContext() {
        MockitoAnnotations.initMocks(this);
    }

    @Bean
    public UserDao userDaoMock() {
        return userDaoMock;
    }

    @Bean
    public EventDao eventDaoMock() {
        return eventDaoMock;
    }

}




