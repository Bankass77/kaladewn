package ml.kalanblow.kaladewn.domain.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ml.kalanblow.kaladewn.constraint.EmailConstraint;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Email {

	@EmailConstraint
	private String email;

	public String asString() {
		return email;
	}

}
