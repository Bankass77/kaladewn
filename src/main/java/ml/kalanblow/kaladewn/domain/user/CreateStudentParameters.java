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
    private final Email email;
    private final PhoneNumber phoneNumber;
     private Address address;
}
