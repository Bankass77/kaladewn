/*
 * package ml.kalanblow.kaladewn.repository;
 * 
 * import static org.assertj.core.api.Assertions.assertThat;
 * 
 * import java.time.LocalDate; import java.time.LocalDateTime; import
 * java.time.format.DateTimeFormatter; import
 * java.time.format.DateTimeFormatterBuilder; import java.util.List; import
 * java.util.Locale;
 * 
 * import javax.persistence.EntityManager; import
 * javax.persistence.PersistenceContext; import
 * org.junit.jupiter.api.BeforeEach; import org.junit.jupiter.api.Order;
 * //import org.junit.jupiter.api.Disabled; import org.junit.jupiter.api.Test;
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
 * import
 * org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.
 * Replace; import
 * org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest; import
 * org.springframework.data.domain.PageRequest; import
 * org.springframework.data.domain.Sort; import
 * org.springframework.jdbc.core.JdbcTemplate; import
 * org.springframework.test.annotation.Commit; import
 * org.springframework.test.context.ActiveProfiles;
 * 
 * import lombok.extern.slf4j.Slf4j; import
 * ml.kalanblow.kaladewn.domain.school.School; import
 * ml.kalanblow.kaladewn.domain.user.Address; import
 * ml.kalanblow.kaladewn.domain.user.Email; import
 * ml.kalanblow.kaladewn.domain.user.Gender; import
 * ml.kalanblow.kaladewn.domain.user.KaladewnUtility; import
 * ml.kalanblow.kaladewn.domain.user.PhoneNumber; import
 * ml.kalanblow.kaladewn.domain.user.Student; import
 * ml.kalanblow.kaladewn.domain.user.UserName;
 * 
 * //@Disabled
 * 
 * @DataJpaTest
 * 
 * @ActiveProfiles("dev")
 * 
 * @Slf4j
 * 
 * @AutoConfigureTestDatabase(replace = Replace.NONE) class
 * StudentRepositoryTest {
 * 
 * private final StudentRepository studentRepository; private final
 * SchoolRepository schoolRepository;
 * 
 * private final JdbcTemplate jdbcTemplate;
 * 
 * @PersistenceContext private EntityManager entityManager;
 * 
 * @Autowired public StudentRepositoryTest(StudentRepository studentRepository,
 * SchoolRepository schoolRepository, JdbcTemplate jdbcTemplate, EntityManager
 * entityManager) { super(); this.studentRepository = studentRepository;
 * this.schoolRepository = schoolRepository; this.jdbcTemplate = jdbcTemplate;
 * this.entityManager = entityManager; }
 * 
 * @BeforeEach void validatePreconditions() {
 * 
 * assertThat(studentRepository.count()).isZero(); }
 * 
 * @Test
 * 
 * @Order(2) // @Transactional
 * 
 * @Commit void testSaveStudent() { DateTimeFormatter df = new
 * DateTimeFormatterBuilder() // case insensitive to parse JAN and FEB
 * .parseCaseInsensitive() // add pattern .appendPattern("dd-MM-yyyy") // create
 * formatter (use English Locale to parse month names)
 * .toFormatter(Locale.FRENCH); var student = new Student(); var address = new
 * Address(); address.setCity("Bamako"); address.setCodePostale(9999);
 * address.setCountry("Mali"); address.setStreet("Rue du soleil levant");
 * address.setStreetNumber(34); student.setAddress(address); var bithDate =
 * LocalDate.parse("27-06-2002", df); student.setBirthDate(bithDate); var email
 * = new Email(); email.setEmail("user@domain.com "); student.setEmail(email);
 * student.setCreatedDate(LocalDateTime.now());
 * student.setGender(Gender.FEMALE); student.setModifyDate(LocalDateTime.now());
 * student.setPhoneNumber(new PhoneNumber("09568743")); UserName userName = new
 * UserName(); String firstName = "tartapion"; userName.setFirstName(firstName);
 * String lastName = "serpiere"; userName.setLastName(lastName);
 * student.setUserName(userName); String fatherFistName = "Gaoussou"; String
 * fatherLastname = "Traore"; student.setFatherFirstName(fatherFistName);
 * student.setFatherLastName(fatherLastname); student.setFatherMobile(new
 * PhoneNumber("0645893421")); String motherFirtName = "Aminata"; String
 * motherLastName = "Wade"; student.setMotherFirstName(motherFirtName);
 * student.setMotherLastName(motherLastName); student.setMotherMobile(new
 * PhoneNumber("0734864532")); student.setModifyDate(LocalDateTime.now());
 * student.setGender(Gender.FEMALE); student.setAddress(address); String
 * ineNumber =
 * KaladewnUtility.generatingandomAlphaNumericStringWithFixedLength();
 * student.setIneNumber(ineNumber);
 * 
 * List<School> schools = schoolRepository.findAll(); for (School school2 :
 * schools) {
 * 
 * if (school2 != null) { student.setSchool(school2); }
 * 
 * }
 * 
 * studentRepository.saveAndFlush(student); entityManager.flush();
 * 
 * Long studentId = jdbcTemplate.queryForObject("SELECT user_id FROM student ",
 * Long.class);
 * 
 * String fullName =
 * jdbcTemplate.queryForObject("SELECT first_name FROM student ", String.class);
 * assertThat(studentId).isNotNull();
 * assertThat(fullName).isEqualTo(userName.getFirstName());
 * assertThat(jdbcTemplate.queryForObject("SELECT last_name From student",
 * String.class)).isEqualTo("serpiere");
 * assertThat(jdbcTemplate.queryForObject("SELECT gender From student",
 * Gender.class)).isEqualTo(Gender.FEMALE); //
 * assertThat(jdbcTemplate.queryForObject("SELECT created_Date From student", //
 * LocalDateTime.class)).isEqualTo("2022-06-30T19:12:00");
 * assertThat(jdbcTemplate.queryForObject("SELECT email From student",
 * String.class)) .isEqualTo("user@domain.com ");
 * assertThat(jdbcTemplate.queryForObject("SELECT phone_number From student",
 * PhoneNumber.class)) .isEqualTo(student.getPhoneNumber());
 * 
 * }
 * 
 * 
 * @Test void testFindAllPageable() {
 * 
 * saveStudents(10); Sort sort = Sort.by(Sort.Direction.ASC, "user.lastName",
 * "user.firstName");
 * 
 * assertThat(studentRepository.findAll(PageRequest.of(0, 5, sort))).hasSize(5)
 * .extracting(user -> user.getUserName());
 * 
 * assertThat(studentRepository.findAll(PageRequest.of(2, 5,
 * sort))).isNotEmpty(); }
 * 
 * 
 * 
 * private void saveStudents(int numberOfUsers) { for (int i = 0; i <
 * numberOfUsers; i++) { DateTimeFormatter df = new DateTimeFormatterBuilder()
 * // case insensitive to parse JAN and FEB .parseCaseInsensitive() // add
 * pattern .appendPattern("dd-MM-yyyy") // create formatter (use French Locale
 * to parse month names) .toFormatter(Locale.FRENCH); var address = new
 * Address(); address.setCity("Paris"); address.setCodePostale(8796);
 * address.setCountry("France"); address.setStreet("rue Bompart");
 * address.setStreetNumber(2); var student = new Student(); UserName userName =
 * new UserName(); String firstName = "George";
 * userName.setFirstName(firstName); String lastName = "Diabate";
 * userName.setLastName(lastName); student.setUserName(userName); var bithDate =
 * LocalDate.parse("25-06-2008", df); student.setBirthDate(bithDate);
 * student.setCreatedDate(LocalDateTime.now()); student.setEmail(new
 * Email("georges.diabate@example.com")); String fatherFistName = "Gaoussou";
 * String fatherLastname = "Traore"; student.setFatherFirstName(fatherFistName);
 * student.setFatherLastName(fatherLastname); student.setFatherMobile(new
 * PhoneNumber("0645893421")); String motherFirtName = "Aminata"; String
 * motherLastName = "Wade"; student.setMotherFirstName(motherFirtName);
 * student.setMotherLastName(motherLastName); student.setMotherMobile(new
 * PhoneNumber("0734864532")); student.setModifyDate(LocalDateTime.now());
 * student.setGender(Gender.FEMALE); student.setAddress(address); String
 * ineNumber =
 * KaladewnUtility.generatingandomAlphaNumericStringWithFixedLength();
 * student.setIneNumber(ineNumber);
 * 
 * studentRepository.save(student);
 * 
 * } }
 * 
 * // @Transactional
 * 
 * @Commit public void testOneToManyDeletion() {
 * 
 * log.info("Deleteion user: {}", "Student deletion");
 * studentRepository.findAll().stream().forEach(u -> log.info("User:{}, {}",
 * u.getUserName(), u.getEmail())); }
 * 
 * 
 * }
 */