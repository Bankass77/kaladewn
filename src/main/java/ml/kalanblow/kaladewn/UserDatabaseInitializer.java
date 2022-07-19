/*
 * package ml.kalanblow.kaladewn;
 * 
 * import java.text.SimpleDateFormat; import java.time.LocalDate; import
 * java.time.format.DateTimeFormatter; import
 * java.time.format.DateTimeFormatterBuilder; import java.util.Locale;
 * 
 * import org.springframework.boot.CommandLineRunner; import
 * org.springframework.context.annotation.Profile; import
 * org.springframework.stereotype.Component;
 * 
 * 
 * import com.github.javafaker.Faker; import com.github.javafaker.Name; import
 * org.apache.commons.lang3.StringUtils; import
 * ml.kalanblow.kaladewn.domain.user.Address; import
 * ml.kalanblow.kaladewn.domain.user.CreateStudentParameters; import
 * ml.kalanblow.kaladewn.domain.user.Email; import
 * ml.kalanblow.kaladewn.domain.user.Gender; import
 * ml.kalanblow.kaladewn.domain.user.KaladewnUtility; import
 * ml.kalanblow.kaladewn.domain.user.PhoneNumber; import
 * ml.kalanblow.kaladewn.domain.user.UserName; import
 * ml.kalanblow.kaladewn.service.SchoolService; import
 * ml.kalanblow.kaladewn.service.StudentService;
 * 
 * @Component
 * 
 * @Profile("dev") public class UserDatabaseInitializer implements
 * CommandLineRunner {
 * 
 * private final Faker faker = new Faker();
 * 
 * private StudentService studentService; private SchoolService schoolService;
 * 
 * public UserDatabaseInitializer(StudentService studentService, SchoolService
 * schoolService) { super(); this.studentService = studentService;
 * this.schoolService=schoolService; }
 * 
 * @Override public void run(String... args) throws Exception {
 * 
 * for (int i = 0; i < 20; i++) { CreateStudentParameters parameters =
 * randomStudentParameters(); studentService.createStudent(parameters); }
 * 
 * }
 * 
 * private CreateStudentParameters randomStudentParameters() {
 * 
 * SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy"); DateTimeFormatter
 * df = new DateTimeFormatterBuilder() // case insensitive to parse JAN and FEB
 * .parseCaseInsensitive() // add pattern .appendPattern("dd-MM-yyyy") // create
 * formatter (use English Locale to parse month names)
 * .toFormatter(Locale.FRENCH);
 * 
 * Name name = faker.name(); PhoneNumber phoneNumber = new
 * PhoneNumber(faker.phoneNumber().phoneNumber());
 * 
 * UserName userName = new UserName(name.firstName(), name.lastName()); Address
 * address = new Address(); address.setCity(faker.address().city());
 * address.setCountry(faker.address().country());
 * address.setCodePostale(Integer.valueOf(faker.address().zipCode().substring(0,
 * 4))); address.setStreet(faker.address().streetAddress());
 * address.setStreetNumber(Integer.valueOf(faker.address().streetAddressNumber()
 * )); String numeroIne =
 * KaladewnUtility.generatingandomAlphaNumericStringWithFixedLength();
 * 
 * PhoneNumber motherMobile = new
 * PhoneNumber(faker.phoneNumber().phoneNumber());
 * 
 * PhoneNumber fatherMobile = new
 * PhoneNumber(faker.phoneNumber().phoneNumber());
 * 
 * LocalDate birthday = LocalDate.parse(sdf.format(faker.date().birthday()),
 * df);
 * 
 * Email email= new Email();
 * email.setEmail(faker.internet().emailAddress(generateEmailLocalPart(userName)
 * .asString())); String email2 = email.asString();
 * 
 * return new CreateStudentParameters(userName, Gender.FEMALE, birthday, email2,
 * phoneNumber, address, numeroIne, userName.getFirstName(),
 * userName.getLastName(), userName.getFirstName(), userName.getLastName(),
 * fatherMobile, motherMobile);
 * 
 * }
 * 
 * private Email generateEmailLocalPart(UserName userName) {
 * 
 * return new Email(String.format("%s.%s",
 * StringUtils.remove(userName.getFirstName().toLowerCase(), "'"),
 * StringUtils.remove(userName.getLastName().toLowerCase(), "'"))); }
 * 
 * }
 */