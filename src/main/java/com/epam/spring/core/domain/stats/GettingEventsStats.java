package com.epam.spring.core.domain.stats;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Dmytro_Adonin
 * @since 2/23/2016.
 */
@Entity
public class GettingEventsStats {

    @Id
    private Integer eventId;
    private Integer gettingCounter;

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public Integer getGettingCounter() {
        return gettingCounter;
    }

    public void setGettingCounter(Integer gettingCounter) {
        this.gettingCounter = gettingCounter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GettingEventsStats that = (GettingEventsStats) o;

        if (eventId != null ? !eventId.equals(that.eventId) : that.eventId != null) return false;
        return gettingCounter != null ? gettingCounter.equals(that.gettingCounter) : that.gettingCounter == null;

    }

    @Override
    public int hashCode() {
        int result = eventId != null ? eventId.hashCode() : 0;
        result = 31 * result + (gettingCounter != null ? gettingCounter.hashCode() : 0);
        return result;
    }

}
