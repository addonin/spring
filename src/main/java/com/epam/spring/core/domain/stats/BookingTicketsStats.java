package com.epam.spring.core.domain.stats;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Dmytro_Adonin
 * @since 2/23/2016.
 */
@Entity
public class BookingTicketsStats {

    @Id
    private Integer eventId;

    private Integer bookingTicketsCounter;

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public Integer getBookingTicketsCounter() {
        return bookingTicketsCounter;
    }

    public void setBookingTicketsCounter(Integer bookingTicketsCounter) {
        this.bookingTicketsCounter = bookingTicketsCounter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookingTicketsStats that = (BookingTicketsStats) o;

        if (eventId != null ? !eventId.equals(that.eventId) : that.eventId != null) return false;
        return bookingTicketsCounter != null ? bookingTicketsCounter.equals(that.bookingTicketsCounter) : that.bookingTicketsCounter == null;

    }

    @Override
    public int hashCode() {
        int result = eventId != null ? eventId.hashCode() : 0;
        result = 31 * result + (bookingTicketsCounter != null ? bookingTicketsCounter.hashCode() : 0);
        return result;
    }
}
