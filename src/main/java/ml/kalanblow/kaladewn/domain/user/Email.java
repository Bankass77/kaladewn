package ml.kalanblow.kaladewn.domain.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Email {
	
	private String email;
	
	 public String asString() {
	        return email;
	    }

}
