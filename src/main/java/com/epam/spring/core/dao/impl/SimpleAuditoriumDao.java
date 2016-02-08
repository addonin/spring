package com.epam.spring.core.dao.impl;

import com.epam.spring.core.dao.AuditoriumDao;
import com.epam.spring.core.domain.Auditorium;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Dmytro_Adonin
 * @since 2/5/2016.
 */
@Repository
public class SimpleAuditoriumDao implements AuditoriumDao {

    private volatile int counter;

    private Map<Integer, Auditorium> auditoriumMap = new HashMap<>();

    @Autowired
    private List<Auditorium> auditoriumList;

    @PostConstruct
    public void init() {
        auditoriumList.stream().forEach(item -> {
            int id = generateId();
            item.setId(id);
            auditoriumMap.put(id, item);
        });
    }

    @Override
    public List<Auditorium> getAuditoriums() {
        return auditoriumList;
    }

    @Override
    public Integer getSeatsNumber(Integer auditoriumId) {
        return auditoriumMap.containsKey(auditoriumId) ? auditoriumMap.get(auditoriumId).getSeatsNumber() : null;
    }

    @Override
    public List<Integer> getVipSeats(Integer auditoriumId) {
        return auditoriumMap.containsKey(auditoriumId) ? auditoriumMap.get(auditoriumId).getVipSeats() : null;
    }

    private int generateId() {
        return counter++;
    }
}
