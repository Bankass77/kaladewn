package ml.kalanblow.kaladewn.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ActiveProfiles;

import lombok.extern.slf4j.Slf4j;
import ml.kalanblow.kaladewn.domain.school.School;
import ml.kalanblow.kaladewn.domain.user.Address;
import ml.kalanblow.kaladewn.domain.user.Email;
import ml.kalanblow.kaladewn.domain.user.PhoneNumber;

@DataJpaTest
@ActiveProfiles("dev")
@Slf4j
@Disabled
@AutoConfigureTestDatabase(replace = Replace.NONE)
class SchoolRepositoryTest {

	private final SchoolRepository schoolRepository;

	private final JdbcTemplate jdbcTemplate;

	@PersistenceContext
	private EntityManager entityManager;
     
	@Autowired
	public SchoolRepositoryTest(SchoolRepository schoolRepository, JdbcTemplate jdbcTemplate,
			EntityManager entityManager) {
		super();
		this.schoolRepository = schoolRepository;
		this.jdbcTemplate = jdbcTemplate;
		this.entityManager = entityManager;
	}
	
	

	@BeforeEach
	void validatePreconditions() {

		assertThat(schoolRepository.count()).isZero();
	}

	@Test
	void testFindByName() {
		fail("Not yet implemented");
	}

	@Test
	void testFindByPhoneNumber() {
		fail("Not yet implemented");
	}

	@Test
	void testFindByAddress() {
		fail("Not yet implemented");
	}

	@Test
	void testFindByEmail() {
		fail("Not yet implemented");
	}

	@Test
	void testFindAllByName() {
		fail("Not yet implemented");
	}
	
	@Test
	@Order(1)
	@Transactional
	@Commit
	void saveSchool() {

		School school = new School();
		school.setEmail(new Email("mamadou.kanate@example.com").asString());
		school.setName("Mamadou Konate");
		school.setPhoneNumber(new PhoneNumber("0023378453275"));

		Address address = new Address();
		address.setCity("Bamako");
		address.setCodePostale(99999);
		address.setCountry("Mali");
		address.setStreet("General Koumare");
		address.setStreetNumber(77);
		school.setAddress(address);

		schoolRepository.save(school);
		entityManager.flush();
	}

}
