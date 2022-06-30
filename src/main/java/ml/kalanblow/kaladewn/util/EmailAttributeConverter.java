package ml.kalanblow.kaladewn.util;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import ml.kalanblow.kaladewn.domain.user.Email;

@Converter(autoApply = true)
public class EmailAttributeConverter implements AttributeConverter<Email, String> {

	@Override
	public String convertToDatabaseColumn(Email attribute) {

		return attribute.asString();
	}

	@Override
	public Email convertToEntityAttribute(String dbData) {

		return new Email(dbData);
	}

}
