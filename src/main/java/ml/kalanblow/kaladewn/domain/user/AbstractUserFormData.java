package ml.kalanblow.kaladewn.domain.user;

import java.time.LocalDate;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ml.kalanblow.kaladewn.constraint.EmailConstraint;
import ml.kalanblow.kaladewn.constraint.FrenchPhoneConstraint;
import ml.kalanblow.kaladewn.constraint.NotExistingUser;
import ml.kalanblow.kaladewn.validation.ValidationGroupOne;
import ml.kalanblow.kaladewn.validation.ValidationGroupTwo;

@NotExistingUser(groups = ValidationGroupTwo.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AbstractUserFormData {

	@NotBlank
	@Size(min = 1, max = 200, groups = ValidationGroupOne.class)
	private String firstName;
	@NotBlank
	@Size(min = 1, max = 200, groups = ValidationGroupOne.class)
	private String lastName;
	@NotNull
	private Gender gender;
	@NotBlank
	@EmailConstraint(groups = ValidationGroupOne.class)
	private String email;
	@NotNull
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate birthday;
	@NotBlank
	@FrenchPhoneConstraint(groups = ValidationGroupOne.class)
	private String phoneNumber;
	@NotNull
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "street", column = @Column(name = "street")),

			@AttributeOverride(name = "streetNumber", column = @Column(name = "streetNumber")),

			@AttributeOverride(name = "codePostal", column = @Column(name = "codePostale")),

			@AttributeOverride(name = "city", column = @Column(name = "city")),
			@AttributeOverride(name = "country", column = @Column(name = "country")) })
	private Address address;

}
