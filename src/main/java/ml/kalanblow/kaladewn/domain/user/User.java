package ml.kalanblow.kaladewn.domain.user;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import groovy.transform.EqualsAndHashCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import ml.kalanblow.kaladewn.constraint.EmailConstraint;
import ml.kalanblow.kaladewn.domain.school.School;

@Entity
@Data
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Accessors(chain = true)
@Table(name = "user", uniqueConstraints = @UniqueConstraint(columnNames = "user_Id"), indexes = @Index(name = "idx_user_email", columnList = "email", unique = true))
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING, name = "USER_TYPE")
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = { "school" })
@EqualsAndHashCode(excludes = { "school" })
public abstract class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_Id", nullable = false, unique = true, insertable = false, updatable = false)
	private Long userId;

	@NotNull
	@Embedded
	private UserName userName;

	@NotNull
	@Column(name = "birthDate")
	@Past
	@DateTimeFormat(pattern = "dd-MM-yyyy")
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

	@NotNull(message = "Please enter a valid address email.")
	@Column(unique = true, nullable = false, updatable = true, name = "email")
	@EmailConstraint
	private String email;

	@NotNull
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "street", column = @Column(name = "street")),

			@AttributeOverride(name = "streetNumber", column = @Column(name = "streetNumber")),

			@AttributeOverride(name = "codePostal", column = @Column(name = "codePostale")),

			@AttributeOverride(name = "city", column = @Column(name = "city")),
			@AttributeOverride(name = "country", column = @Column(name = "country")) })
	private Address address;

	@JsonIgnore

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "school_Id", nullable = false)
	private School school;

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
		return userName.getFirstName() != null ? userName.getFirstName().concat(" ").concat(userName.getLastName())
				: " ";

	}

}
