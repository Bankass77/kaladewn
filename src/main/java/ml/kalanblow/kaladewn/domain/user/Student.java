package ml.kalanblow.kaladewn.domain.user;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;

@Entity
@Table(name = "student")
@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class Student implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "userId", nullable = false, unique = true)
	private Long userId;

	@NotNull
	@Embedded
	private UserName userName;

	@NotNull
	@Column(name = "birthDate")
	@Past
	private LocalDate birthDate;

	@NotNull
	@Column(nullable = false, name = "createdDate", updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@CreatedDate
	private LocalDateTime createdDate;

	@NotNull
	@Column(nullable = false, name = "modifyDate", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@LastModifiedDate
	private LocalDateTime modifyDate;

	@Enumerated(EnumType.STRING)
	@Column(name = "gender"/* , columnDefinition = "ENUM(MALE('M'), FEMALE('F')) " */)
	private Gender gender;

	@NotNull
	@Column(insertable = true, updatable = true, nullable = false, name = "phoneNumber")
	private PhoneNumber phoneNumber;

	@NotNull
	@Column(unique = true, nullable = false, updatable = true, name = "email")
	private Email email;

	@NotNull
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "street", column = @Column(name = "street")),

			@AttributeOverride(name = "streetNumber", column = @Column(name = "streetNumber")),

			@AttributeOverride(name = "codePostal", column = @Column(name = "codePostale")),

			@AttributeOverride(name = "city", column = @Column(name = "city")),
			@AttributeOverride(name = "country", column = @Column(name = "country")) })
	private Address address;


	public Student(UserName userName2, LocalDate birthday, LocalDateTime now, LocalDateTime now2, Gender gender2,
			PhoneNumber phoneNumber2, Email email2, Address address2) {
		this.userName=userName2;
		this.birthDate=birthday;
		this.createdDate=now;
		this.modifyDate=now2;
		this.gender=gender2;
		this.phoneNumber=phoneNumber2;
		this.email=email2;
		this.address=address2;
	}
	@PrePersist
	void onCreate() {
		this.setCreatedDate(LocalDateTime.now());
		this.setModifyDate(LocalDateTime.now());
	}

	@PreUpdate
	void onUpdate() {
		this.setModifyDate(LocalDateTime.now());
	}

	private String getfullName() {
		return userName.getFirstName()!=null?userName.getFirstName().concat(" ").concat(userName.getLastName()):" " ;
		
		
	}


}
