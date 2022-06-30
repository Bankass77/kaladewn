package ml.kalanblow.kaladewn.util;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class DateConverter implements AttributeConverter<LocalDate, Date> {

	@Override
	public Date convertToDatabaseColumn(LocalDate localDate) {
		return localDate != null ? Date.valueOf(localDate) : null;
	}

	@Override
	public LocalDate convertToEntityAttribute(Date date) {
		return date != null ? date.toLocalDate() : null;
	}
}