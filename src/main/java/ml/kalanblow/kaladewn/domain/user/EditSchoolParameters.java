package ml.kalanblow.kaladewn.domain.user;

import java.io.IOException;



import ml.kalanblow.kaladewn.domain.school.School;

public class EditSchoolParameters   extends  CreateSchoolParameters{

	public EditSchoolParameters(String name, PhoneNumber phoneNumber, Email email) {
		super(name, phoneNumber, email);
		
	}
	
	
	// tag::update[]
    public void update(School school) {
        school.setName(getName());

    }
    // end::update[]

}
