package ml.kalanblow.kaladewn.domain.user;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import groovy.transform.EqualsAndHashCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "student")
@PrimaryKeyJoinColumn(name = "userId")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@DiscriminatorValue("Student")
@EqualsAndHashCode(excludes = { "school" })
public class Student extends User {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "ine_number")
	private String ineNumber;

	@Column
	@NotBlank
	@NotNull
	private String motherFirstName;

	@Column
	@NotBlank
	@NotNull
	private String motherLastName;

	@Column
	@NotBlank
	@NotNull
	private String fatherLastName;

	@Column
	@NotBlank
	@NotNull
	private String fatherFirstName;

	@Column
	@NotNull
	private PhoneNumber fatherMobile;

	@Column
	@NotNull
	private PhoneNumber motherMobile;



	

}
