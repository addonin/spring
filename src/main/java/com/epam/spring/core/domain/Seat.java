package com.epam.spring.core.domain;

import com.epam.spring.core.domain.enums.SeatStatus;

/**
 * @author Dmytro_Adonin
 * @since 2/9/2016.
 */
public class Seat {

    private int number;
    private SeatStatus status;

    public Seat(int number, SeatStatus status) {
        this.number = number;
        this.status = status;
    }

    public int getNumber() {
        return number;
    }

    public SeatStatus getStatus() {
        return status;
    }
}
