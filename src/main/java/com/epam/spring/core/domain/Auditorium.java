package com.epam.spring.core.domain;

import java.util.List;

/**
 * @author Dmytro_Adonin
 * @since 2/5/2016.
 */
public class Auditorium {

    private String name;
    private int number;
    private List<Integer> vip;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<Integer> getVip() {
        return vip;
    }

    public void setVip(List<Integer> vip) {
        this.vip = vip;
    }
}
