package com.epam.spring.core.dao.impl;

import com.epam.spring.core.dao.UserDao;
import com.epam.spring.core.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * @author Dmytro_Adonin
 * @since 2/5/2016.
 */
@Repository
public class SimpleUserDao implements UserDao {

    private volatile int counter;

    private Map<Integer, User> users;

    public Integer register(User user) {
        if (!users.containsKey(user.getId())) {
            user.setId(generateId());
            users.put(user.getId(), user);
        }
        return user.getId();
    }

    private int generateId() {
        return counter++;
    }

}
