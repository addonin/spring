package com.epam.spring.core.domain;

import java.util.List;

/**
 * @author Dmytro_Adonin
 * @since 2/5/2016.
 */
public class Auditorium {

    private Integer id;
    private String name;
    private int seatsNumber;
    private List<Integer> vipSeats;

    public Auditorium(String name, int seatsNumber, List<Integer> vipSeats) {
        this.name = name;
        this.seatsNumber = seatsNumber;
        this.vipSeats = vipSeats;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getSeatsNumber() {
        return seatsNumber;
    }

    public List<Integer> getVipSeats() {
        return vipSeats;
    }

}
