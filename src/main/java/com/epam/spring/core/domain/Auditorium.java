package com.epam.spring.core.domain;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import java.util.List;

/**
 * @author Dmytro_Adonin
 * @since 2/5/2016.
 */
@Embeddable
public class Auditorium {

    @Column(name = "auditoriumId")
    private Integer id;
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

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (seatsNumber != null ? !seatsNumber.equals(that.seatsNumber) : that.seatsNumber != null) return false;
        return vipSeats != null ? vipSeats.equals(that.vipSeats) : that.vipSeats == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (seatsNumber != null ? seatsNumber.hashCode() : 0);
        result = 31 * result + (vipSeats != null ? vipSeats.hashCode() : 0);
        return result;
    }
}
