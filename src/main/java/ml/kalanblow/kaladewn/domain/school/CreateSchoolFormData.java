package ml.kalanblow.kaladewn.domain.school;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import ml.kalanblow.kaladewn.constraint.EmailConstraint;
import ml.kalanblow.kaladewn.domain.user.Address;
import ml.kalanblow.kaladewn.domain.user.Email;
import ml.kalanblow.kaladewn.domain.user.PhoneNumber;
import ml.kalanblow.kaladewn.validation.ValidationGroupOne;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateSchoolFormData {

	
	@NotNull
	@NotBlank
	@Size(min = 1, max = 200, groups = ValidationGroupOne.class)
	private String name;

	@NotBlank
	@NotNull
	@Pattern(regexp ="[0-9.\\-() x/+]+", groups = ValidationGroupOne.class )
	private String  phoneNumber;

	@NotBlank
	@NotNull
	@EmailConstraint(groups = ValidationGroupOne.class)
	private String email;

	@NotBlank
	@NotNull
	private Address address;

	public CreateSchoolParameters toParameters() {

	 CreateSchoolParameters parameters= new CreateSchoolParameters(name, new PhoneNumber(getPhoneNumber()) , new Email(getEmail()).asString(),getAddress());

	
	 return parameters;
	}

}
