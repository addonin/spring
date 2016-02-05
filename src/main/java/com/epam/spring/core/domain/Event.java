package com.epam.spring.core.domain;

import com.epam.spring.core.domain.enums.EventRating;

/**
 * @author Dmytro_Adonin
 * @since 2/5/2016.
 */
public class Event {

    private String name;
    private double price;
    private EventRating rating;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public EventRating getRating() {
        return rating;
    }

    public void setRating(EventRating rating) {
        this.rating = rating;
    }
}
