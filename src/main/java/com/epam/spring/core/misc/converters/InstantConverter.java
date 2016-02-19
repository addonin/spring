package com.epam.spring.core.misc.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.Instant;
import java.util.Date;

/**
 * @author Dmytro_Adonin
 * @since 2/19/2016.
 */
@Converter(autoApply = true)
public class InstantConverter implements AttributeConverter<Instant, Date> {

    @Override
    public Date convertToDatabaseColumn(Instant instant) {
        return Date.from(instant);
    }

    @Override
    public Instant convertToEntityAttribute(Date value) {
        return value.toInstant();
    }

}
