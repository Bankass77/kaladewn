package ml.kalanblow.kaladewn.domain.user;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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

	@NotBlank
	@NotNull
	@Size(min = 2, max = 200)
	private String firstName;

	@NotBlank
	@Size(min = 2, max = 200)
	@NotNull
	private String lastName;

}
