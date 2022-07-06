package ml.kalanblow.kaladewn.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;

import ml.kalanblow.kaladewn.domain.user.Address;
import ml.kalanblow.kaladewn.domain.user.Email;
import ml.kalanblow.kaladewn.domain.user.Gender;
import ml.kalanblow.kaladewn.domain.user.PhoneNumber;
import ml.kalanblow.kaladewn.domain.user.Student;
import ml.kalanblow.kaladewn.domain.user.UserName;

@DataJpaTest
@ActiveProfiles("dev")
@AutoConfigureTestDatabase(replace = Replace.NONE)
class StudentRepositoryTest {

	private final StudentRepository studentRepository;

	private final JdbcTemplate jdbcTemplate;

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	public StudentRepositoryTest(StudentRepository studentRepository, JdbcTemplate jdbcTemplate) {
		super();
		this.studentRepository = studentRepository;
		this.jdbcTemplate = jdbcTemplate;
	}

	@BeforeEach
	void validatePreconditions() {

		assertThat(studentRepository.count()).isZero();
	}

	@Test
	void testSaveStudent() {
		Student student = new Student();
		Address address = new Address();
		address.setCity("Bamako");
		address.setCodePostale(9999);
		address.setCountry("Mali");
		address.setStreet("Rue du soleil levant");
		address.setStreetNumber(34);
		;
		student.setAddress(address);
		student.setBirthDate(LocalDate.of(1978, 6, 27));
		Email email = new Email();
		email.setEmail("example3@aexample.com");
		student.setEmail(email);
		student.setCreatedDate(LocalDateTime.now());
		student.setGender(Gender.FEMALE);
		student.setModifyDate(LocalDateTime.now());
		PhoneNumber phoneNumber= new PhoneNumber();
		phoneNumber.setPhoneNumber("09568743");
		student.setPhoneNumber(phoneNumber);
		UserName userName = new UserName();
		userName.setFirstName("tartapion");
		userName.setLastName("serpiere");
		student.setUserName(userName );
		studentRepository.save(student);
		entityManager.flush();
		
		Long studentId= jdbcTemplate.queryForObject("SELECT user_id FROM student ", Long.class);
		
		String fullName=jdbcTemplate.queryForObject("SELECT first_name FROM student ", String.class);
		assertThat(studentId).isNotNull();
		assertThat(fullName).isEqualTo(userName.getFirstName());
		assertThat(jdbcTemplate.queryForObject("SELECT last_name From student",  String.class)).isEqualTo("serpiere");
				assertThat(jdbcTemplate.queryForObject("SELECT gender From student",  Gender.class)).isEqualTo(Gender.FEMALE);
				//assertThat(jdbcTemplate.queryForObject("SELECT created_Date From student",  LocalDateTime.class)).isEqualTo("2022-06-30T19:12:00");
				assertThat(jdbcTemplate.queryForObject("SELECT email From student",  String.class)).isEqualTo("example3@aexample.com");
				assertThat(jdbcTemplate.queryForObject("SELECT phone_number From student",  PhoneNumber.class)).isEqualTo(student.getPhoneNumber());
				
	}
}
