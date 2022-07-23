package ml.kalanblow.kaladewn.domain.user;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
public class EditStudentFormData extends CreateStudentFormData {

	public EditStudentFormData(UserName userName, LocalDate birthDate, LocalDateTime createdDate,
			LocalDateTime modifyDate, Gender gender, PhoneNumber phoneNumber, String email, Address address,
			String ineNumber, String motherFirstName, String motherLastName, PhoneNumber motherMobile,
			String fatherLastName, String fatherFirstName, PhoneNumber fatherMobile) {

	}

	public static EditStudentFormData fromStudent(Student student) {
		return new EditStudentFormData(student.getUserName(), student.getBirthDate(), student.getCreatedDate(),
				student.getModifyDate(), student.getGender(), student.getPhoneNumber(), student.getEmail(),
				student.getAddress(), student.getIneNumber(), student.getMotherFirstName(), student.getMotherLastName(),
				student.getMotherMobile(), student.getFatherLastName(), student.getFatherFirstName(),
				student.getFatherMobile());

	}

	public EditStudentParameters toParameters() {

		EditStudentParameters parameters = new EditStudentParameters(getUserName(), getGender(), getBirthday(),
				getEmail(), getStudentPhoneNumber(), getAddress(), getIneNumber(), getMotherFirstName(),
				getMotherLastName(), getMotherMobile(), getFatherLastName(), getFatherFirstName(), getFatherMobile());

		return parameters;

	}

}
