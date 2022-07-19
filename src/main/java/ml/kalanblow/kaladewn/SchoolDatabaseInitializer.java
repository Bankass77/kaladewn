
package ml.kalanblow.kaladewn;

import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;

import ml.kalanblow.kaladewn.domain.school.CreateSchoolParameters;
import ml.kalanblow.kaladewn.domain.user.Address;
import ml.kalanblow.kaladewn.domain.user.Email;
import ml.kalanblow.kaladewn.domain.user.PhoneNumber;
import ml.kalanblow.kaladewn.domain.user.UserName;
import ml.kalanblow.kaladewn.service.SchoolService;

@Component

@Profile("dev")
public class SchoolDatabaseInitializer implements CommandLineRunner {

	private final Faker faker = new Faker();

	private SchoolService schoolService;

	public SchoolDatabaseInitializer(SchoolService schoolService) {
		super();
		this.schoolService = schoolService;
	}

	@Override
	public void run(String... args) throws Exception {

		for (int i = 0; i < 10; i++) {

			CreateSchoolParameters parameters = newRandomSchoolParameters();

			schoolService.createNewSchool(parameters);

		}
	}

	private CreateSchoolParameters newRandomSchoolParameters() {

		Name name = faker.name();
		PhoneNumber phoneNumber = new PhoneNumber(faker.phoneNumber().phoneNumber());

		UserName userName = new UserName(name.firstName(), name.lastName());
		Address address = new Address();
		address.setCity(faker.address().city());
		address.setCodePostale(Integer.valueOf(faker.address().zipCode().substring(0, 4)));
		address.setStreet(faker.address().streetAddress());
		address.setStreetNumber(Integer.valueOf(faker.address().streetAddressNumber()));

		Email email = new Email();
		email.setEmail(faker.internet().emailAddress(generateEmailLocalPart(userName)));

		return new CreateSchoolParameters(name.name(), phoneNumber, email.asString(), address);
	}

	private String generateEmailLocalPart(UserName userName) {

		return String.format("%s.%s", StringUtils.remove(userName.getFirstName().toLowerCase(), "'"),
				StringUtils.remove(userName.getLastName().toLowerCase(), "'"));
	}

}
