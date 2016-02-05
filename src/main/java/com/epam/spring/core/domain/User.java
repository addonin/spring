package com.epam.spring.core.domain;

import com.epam.spring.core.domain.enums.UserRole;

/**
 * @author Dmytro_Adonin
 * @since 2/5/2016.
 */
public class User {

    private Integer id;
    private String name;
    private String email;
    private UserRole role;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

}
