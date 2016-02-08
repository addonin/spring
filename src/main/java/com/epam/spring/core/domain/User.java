package com.epam.spring.core.domain;

import com.epam.spring.core.domain.enums.UserRole;

import java.time.Instant;
import java.util.List;

/**
 * @author Dmytro_Adonin
 * @since 2/5/2016.
 */
public class User {

    private Integer id;
    private UserRole role;
    private String name;
    private String email;
    private Instant birthday;
    private List<Ticket> tickets;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
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

    public Instant getBirthday() {
        return birthday;
    }

    public void setBirthday(Instant birthday) {
        this.birthday = birthday;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

}
