package ml.kalanblow.kaladewn.domain.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateSchoolParameters {

	private final String name;
	private final PhoneNumber phoneNumber;
	private final Email email;
	private final Address address;
	
}
