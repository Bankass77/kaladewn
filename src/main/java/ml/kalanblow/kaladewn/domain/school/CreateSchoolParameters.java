package ml.kalanblow.kaladewn.domain.school;

import lombok.AllArgsConstructor;
import lombok.Data;
import ml.kalanblow.kaladewn.domain.user.Address;
import ml.kalanblow.kaladewn.domain.user.Email;
import ml.kalanblow.kaladewn.domain.user.PhoneNumber;

@Data
@AllArgsConstructor
public class CreateSchoolParameters {

	private final String name;
	private final PhoneNumber phoneNumber;
	private final String email;
	private final Address address;
	

}
