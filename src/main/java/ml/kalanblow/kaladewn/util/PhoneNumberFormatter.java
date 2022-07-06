package ml.kalanblow.kaladewn.util;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import ml.kalanblow.kaladewn.domain.user.PhoneNumber;

public class PhoneNumberFormatter implements Formatter<PhoneNumber> {

	@Override
	public String print(PhoneNumber object, Locale locale) {

		return object.asString();
	}

	@Override
	public PhoneNumber parse(String text, Locale locale) throws ParseException {

		return new PhoneNumber(text);
	}

}
