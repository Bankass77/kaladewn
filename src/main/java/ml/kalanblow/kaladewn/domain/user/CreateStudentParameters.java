package ml.kalanblow.kaladewn.domain.user;

import java.time.LocalDate;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
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
	private final String fatherLastName;
	private final String fatherFirstName;
	private final PhoneNumber fatherMobile;
	private final PhoneNumber motherMobile;
}
