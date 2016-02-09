package com.epam.spring.core.dao.impl;

import com.epam.spring.core.dao.UserDao;
import com.epam.spring.core.domain.Ticket;
import com.epam.spring.core.domain.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Dmytro_Adonin
 * @since 2/5/2016.
 */
@Repository
public class SimpleUserDao implements UserDao {

    private volatile int counter;

    private Map<Integer, User> users = new HashMap<>();

    @Override
    public Integer register(User user) {
        if (!users.containsKey(user.getId())) {
            user.setId(generateId());
            users.put(user.getId(), user);
        }
        return user.getId();
    }

    @Override
    public boolean remove(Integer userId) {
        return users.remove(userId, users.get(userId));
    }

    @Override
    public User getById(Integer userId) {
        return users.get(userId);
    }

    @Override
    public User getUserByEmail(String email) {
        //TODO check email not null
        return users.values().stream().map(user -> email.equals(user.getEmail()) ? user : null).findFirst().get();
    }

    @Override
    public List<User> getUserByName(String name) {
        //TODO check name not null
        return users.values().stream().map(user -> name.equals(user.getName()) ? user : null).collect(Collectors.toList());
    }

    @Override
    public List<Ticket> getBookedTickets(Integer userId) {
        return users.get(userId).getTickets();
    }

    private int generateId() {
        return counter++;
    }

}
