package ml.kalanblow.kaladewn.domain.school;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ml.kalanblow.kaladewn.domain.user.Address;
import ml.kalanblow.kaladewn.domain.user.Email;
import ml.kalanblow.kaladewn.domain.user.PhoneNumber;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EditSchoolFormData extends CreateSchoolFormData {

	private long id;
	
	public EditSchoolFormData(String name, PhoneNumber phoneNumber, Email email, Address address) {
		
	}

	public static EditSchoolFormData fromSchool(School school) {
		return new EditSchoolFormData(school.getName(), school.getPhoneNumber(), school.getEmail(),
				school.getAddress());

	}

	public EditSchoolParameters toParameters() {

		return new EditSchoolParameters(getName(), getPhoneNumber(), getEmail(), getAddress());
	}

	
}
