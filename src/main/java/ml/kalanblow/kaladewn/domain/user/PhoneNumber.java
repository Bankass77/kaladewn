package ml.kalanblow.kaladewn.domain.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PhoneNumber {

	private String phoneNumber;

	
	public String asString() {

		return phoneNumber;
	}

}
