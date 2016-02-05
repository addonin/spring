package com.epam.spring.core.dao;

import com.epam.spring.core.domain.User;

/**
 * @author Dmytro_Adonin
 * @since 2/5/2016.
 */
public interface UserDao {

    Integer register(User user);

}
