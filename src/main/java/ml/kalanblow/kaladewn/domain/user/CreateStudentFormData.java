package ml.kalanblow.kaladewn.domain.user;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

public class CreateStudentFormData {
	@NotBlank
	private String firstName;
	@NotBlank
	private String lastName;
	@NotNull
	private Gender gender;
	@NotBlank
	@Email
	private String email;
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate birthday;

	@NotBlank
	@Pattern(regexp = "^(?:(?:\\\\+|00)33[\\\\s.-]{0,3}(?:\\\\(0\\\\)[\\\\s.-]{0,3})?|0)[1-9](?:(?:[\\\\s.-]?\\\\d{2}){4}|\\\\d{2}(?:[\\\\s.-]?\\\\d{3}){2})$")
	private String phoneNumber;

}
