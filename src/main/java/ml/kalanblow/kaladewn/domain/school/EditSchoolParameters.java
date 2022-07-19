package ml.kalanblow.kaladewn.domain.school;

import ml.kalanblow.kaladewn.domain.user.Address;
import ml.kalanblow.kaladewn.domain.user.Email;
import ml.kalanblow.kaladewn.domain.user.PhoneNumber;

public class EditSchoolParameters extends CreateSchoolParameters {



	// tag::update[]
	public EditSchoolParameters(String name, PhoneNumber phoneNumber, String email, Address address) {
		super(name, phoneNumber, email, address);
		
	}

	public void update(School school) {
		school.setName(getName());
		school.setAddress(getAddress());
		school.setPhoneNumber(getPhoneNumber());
		school.setEmail(getEmail());

	}
	// end::update[]

}
