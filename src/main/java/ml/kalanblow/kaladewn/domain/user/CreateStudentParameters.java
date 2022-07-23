package ml.kalanblow.kaladewn.domain.user;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateStudentParameters {
	private final UserName userName;
	private final Gender gender;
	private final LocalDate birthday;
	private final String email;
	private final PhoneNumber phoneNumber;
	private final Address address;
	private final String studentIneNumber;
	private final String motherFirstName;
	private final String motherLastName;
	private final PhoneNumber fatherMobile;
	private final String fatherLastName;
	private final String fatherFirstName;
	private final PhoneNumber motherMobile;
}
