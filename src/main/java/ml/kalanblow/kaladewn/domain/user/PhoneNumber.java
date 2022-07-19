package ml.kalanblow.kaladewn.domain.user;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ml.kalanblow.kaladewn.constraint.FrenchPhoneConstraint;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhoneNumber {

	@FrenchPhoneConstraint
	@NotBlank
	private String phoneNumber;

	public String asString() {

		return phoneNumber;
	}

}
