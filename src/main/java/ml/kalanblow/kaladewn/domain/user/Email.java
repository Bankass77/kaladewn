package ml.kalanblow.kaladewn.domain.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Email {

	private String email;

	public String asString() {
		return email;
	}

}
