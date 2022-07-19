package ml.kalanblow.kaladewn.domain.school;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import groovy.transform.EqualsAndHashCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import ml.kalanblow.kaladewn.constraint.EmailConstraint;
import ml.kalanblow.kaladewn.domain.user.Address;
import ml.kalanblow.kaladewn.domain.user.Email;
import ml.kalanblow.kaladewn.domain.user.PhoneNumber;
import ml.kalanblow.kaladewn.domain.user.User;

@Entity
@Table(name = "school",uniqueConstraints = @UniqueConstraint(columnNames = "school_Id"), indexes = @Index(name = "idx_user_email", columnList = "email", unique = true))

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = { "users" })
@EqualsAndHashCode(excludes = { "users" })
public class School implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "school_Id", unique = true, nullable = false)
	private Long schoolId;

	@Column(name = "name")
	private String name;

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "street", column = @Column(name = "street")),

			@AttributeOverride(name = "streetNumber", column = @Column(name = "streetNumber")),

			@AttributeOverride(name = "codePostal", column = @Column(name = "codePostale")),

			@AttributeOverride(name = "city", column = @Column(name = "city")),
			@AttributeOverride(name = "country", column = @Column(name = "country")) })
	private Address address;

	@Column(name = "phoneNumber", insertable = true, updatable = true, nullable = false)
	private PhoneNumber phoneNumber;

	@Column(unique = true, nullable = false, updatable = true, name = "email")
	@EmailConstraint
	private String email;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<User> users;

}
