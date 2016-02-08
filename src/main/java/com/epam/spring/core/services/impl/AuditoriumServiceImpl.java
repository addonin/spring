package com.epam.spring.core.services.impl;

import com.epam.spring.core.dao.AuditoriumDao;
import com.epam.spring.core.domain.Auditorium;
import com.epam.spring.core.services.AuditoriumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Dmytro_Adonin
 * @since 2/5/2016.
 */
@Service
public class AuditoriumServiceImpl implements AuditoriumService {

    @Autowired
    private AuditoriumDao auditoriumDao;

    @Override
    public List<Auditorium> getAuditoriums() {
        return auditoriumDao.getAuditoriums();
    }

    @Override
    public Integer getSeatsNumber(Integer auditoriumId) {
        return auditoriumDao.getSeatsNumber(auditoriumId);
    }

    @Override
    public List<Integer> getVipSeats(Integer auditoriumId) {
        return auditoriumDao.getVipSeats(auditoriumId);
    }
}
