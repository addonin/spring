package com.epam.spring.core.domain.entities;

import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import java.util.List;

/**
 * @author Dmytro_Adonin
 * @since 2/5/2016.
 */
@Embeddable
public class Auditorium {

    private Integer auditoriumId;
    private String name;
    private Integer seatsNumber;
    @ElementCollection
    private List<Integer> vipSeats;

    public Auditorium(String name, Integer seatsNumber, List<Integer> vipSeats) {
        this.name = name;
        this.seatsNumber = seatsNumber;
        this.vipSeats = vipSeats;
    }

    public Auditorium() {
    }

    public Integer getAuditoriumId() {
        return auditoriumId;
    }

    public void setAuditoriumId(Integer auditoriumId) {
        this.auditoriumId = auditoriumId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSeatsNumber() {
        return seatsNumber;
    }

    public void setSeatsNumber(Integer seatsNumber) {
        this.seatsNumber = seatsNumber;
    }

    public List<Integer> getVipSeats() {
        return vipSeats;
    }

    public void setVipSeats(List<Integer> vipSeats) {
        this.vipSeats = vipSeats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Auditorium that = (Auditorium) o;

        if (auditoriumId != null ? !auditoriumId.equals(that.auditoriumId) : that.auditoriumId != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (seatsNumber != null ? !seatsNumber.equals(that.seatsNumber) : that.seatsNumber != null) return false;
        return vipSeats != null ? vipSeats.equals(that.vipSeats) : that.vipSeats == null;

    }

    @Override
    public int hashCode() {
        int result = auditoriumId != null ? auditoriumId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (seatsNumber != null ? seatsNumber.hashCode() : 0);
        result = 31 * result + (vipSeats != null ? vipSeats.hashCode() : 0);
        return result;
    }
}
