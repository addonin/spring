package com.epam.spring.core.domain;

import com.epam.spring.core.domain.enums.SeatStatus;

import javax.persistence.Embeddable;

/**
 * @author Dmytro_Adonin
 * @since 2/9/2016.
 */
@Embeddable
public class Seat {

    private int number;
    private SeatStatus status;

    public Seat() {
    }

    public Seat(int number, SeatStatus status) {
        this.number = number;
        this.status = status;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public SeatStatus getStatus() {
        return status;
    }

    public void setStatus(SeatStatus status) {
        this.status = status;
    }
}
