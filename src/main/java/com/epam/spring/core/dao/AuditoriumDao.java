package com.epam.spring.core.dao;

import com.epam.spring.core.domain.Auditorium;

import java.util.List;

/**
 * @author Dmytro_Adonin
 * @since 2/5/2016.
 */
public interface AuditoriumDao {

    List<Auditorium> getAuditoriums();

    Integer getSeatsNumber(Integer auditoriumId);

    List<Integer> getVipSeats(Integer auditoriumId);
}
