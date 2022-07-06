package ml.kalanblow.kaladewn.domain.user;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Embeddable
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserName {

	private String firstName;
	private String lastName;

}
