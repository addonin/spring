package com.epam.spring.core.domain.stats;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Dmytro_Adonin
 * @since 2/23/2016.
 */
@Entity
public class DiscountsPerUserStats {

    @Id
    private Integer userId;

    private Integer discountTimesCounter;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getDiscountTimesCounter() {
        return discountTimesCounter;
    }

    public void setDiscountTimesCounter(Integer discountTimesCounter) {
        this.discountTimesCounter = discountTimesCounter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DiscountsPerUserStats that = (DiscountsPerUserStats) o;

        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        return discountTimesCounter != null ? discountTimesCounter.equals(that.discountTimesCounter) : that.discountTimesCounter == null;

    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (discountTimesCounter != null ? discountTimesCounter.hashCode() : 0);
        return result;
    }

}
