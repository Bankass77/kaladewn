package ml.kalanblow.kaladewn.domain.user;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ml.kalanblow.kaladewn.constraint.EmailConstraint;
import ml.kalanblow.kaladewn.constraint.FrenchPhoneConstraint;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateStudentFormData {

	@NotBlank
	@NotNull
	private UserName userName;
	@NotNull
	private Gender gender;
	@NotBlank

	@EmailConstraint
	private String email;

	@FrenchPhoneConstraint
	private PhoneNumber studentPhoneNumber;

	@NotNull
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate birthday;

	private Address address;

	String ineNumber, motherFirstName, motherLastName;

	@FrenchPhoneConstraint
	PhoneNumber motherMobile;

	String fatherLastName, fatherFirstName;

	@FrenchPhoneConstraint
	PhoneNumber fatherMobile;

	public CreateStudentParameters toParameters() {
		CreateStudentParameters parameters= new CreateStudentParameters(userName, gender, birthday, email, studentPhoneNumber, address, ineNumber, motherFirstName, motherLastName, 
				fatherMobile, fatherLastName, fatherFirstName, motherMobile);
		return parameters;
	}
}
