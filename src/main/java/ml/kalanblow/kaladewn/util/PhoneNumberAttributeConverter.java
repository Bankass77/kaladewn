package ml.kalanblow.kaladewn.util;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import ml.kalanblow.kaladewn.domain.user.PhoneNumber;

@Converter(autoApply = true)
public class PhoneNumberAttributeConverter implements AttributeConverter<PhoneNumber, String> {

	@Override
	public String convertToDatabaseColumn(PhoneNumber attribute) {

		return attribute.asString();
	}

	@Override
	public PhoneNumber convertToEntityAttribute(String dbData) {

		return new PhoneNumber(dbData);
	}

}
