package com.epam.spring.core.services;

import com.epam.spring.core.domain.Auditorium;

import java.util.List;

/**
 * @author Dmytro_Adonin
 * @since 2/5/2016.
 */
public interface AuditoriumService {

    List<Auditorium> getAuditoriums();

    int getSeatsNumber();

    List<Integer> getVipSeats();

}
