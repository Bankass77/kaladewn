package ml.kalanblow.kaladewn.domain.school;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import ml.kalanblow.kaladewn.domain.user.Address;
import ml.kalanblow.kaladewn.domain.user.Email;
import ml.kalanblow.kaladewn.domain.user.PhoneNumber;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateSchoolFormData {

	@NotBlank
	@NotNull
	@Size(max = 100)
	private String name;

	@NotBlank
	@NotNull
	private PhoneNumber phoneNumber;

	@NotBlank
	@NotNull
	private Email email;

	@NotBlank
	@NotNull
	private Address address;

	public CreateSchoolParameters toParameters() {

		return new CreateSchoolParameters(name, phoneNumber, email, address);
	}

}
