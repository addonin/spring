package com.epam.spring.core.domain.stats;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Dmytro_Adonin
 * @since 2/23/2016.
 */
@Entity
public class GettingTicketPriceStats {

    @Id
    private Integer eventId;

    private Integer gettingTicketPriceCounter;

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public Integer getGettingTicketPriceCounter() {
        return gettingTicketPriceCounter;
    }

    public void setGettingTicketPriceCounter(Integer gettingTicketPriceCounter) {
        this.gettingTicketPriceCounter = gettingTicketPriceCounter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GettingTicketPriceStats that = (GettingTicketPriceStats) o;

        if (eventId != null ? !eventId.equals(that.eventId) : that.eventId != null) return false;
        return gettingTicketPriceCounter != null ? gettingTicketPriceCounter.equals(that.gettingTicketPriceCounter) : that.gettingTicketPriceCounter == null;

    }

    @Override
    public int hashCode() {
        int result = eventId != null ? eventId.hashCode() : 0;
        result = 31 * result + (gettingTicketPriceCounter != null ? gettingTicketPriceCounter.hashCode() : 0);
        return result;
    }

}
