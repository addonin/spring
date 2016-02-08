package com.epam.spring.core.domain;

import com.epam.spring.core.domain.enums.MovieRating;

import java.time.Duration;

/**
 * @author Dmytro_Adonin
 * @since 2/8/2016.
 */
public class Movie {

    private Integer id;
    private String name;
    private String description;
    private Duration duration;
    private MovieRating rating;
    private Float basePrice;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public MovieRating getRating() {
        return rating;
    }

    public void setRating(MovieRating rating) {
        this.rating = rating;
    }

    public Float getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(Float basePrice) {
        this.basePrice = basePrice;
    }

}
