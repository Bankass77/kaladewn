package ml.kalanblow.kaladewn.domain.user;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class EditStudentParameters extends CreateStudentParameters {

	public EditStudentParameters(UserName userName, Gender gender, LocalDate birthday, String email,
			PhoneNumber phoneNumber, Address address, String studentIneNumber, String motherFirstName,
			String motherLastName,PhoneNumber motherMobile, String fatherLastName,
			 String fatherFirstName, PhoneNumber fatherMobile) {
		super(userName, gender, birthday, email, phoneNumber, address, studentIneNumber, motherFirstName,
				motherLastName, motherMobile, fatherLastName, fatherFirstName, fatherMobile);

	}

	public void updateStudent(Student student) {
		student.setAddress(getAddress());
		student.setBirthDate(getBirthday());
		student.setCreatedDate(LocalDateTime.now());
		student.setEmail(getEmail());
		student.setFatherFirstName(getFatherFirstName());
		student.setFatherLastName(getFatherLastName());
		student.setFatherMobile(getFatherMobile());
		student.setGender(getGender());
		student.setIneNumber(getStudentIneNumber());
		student.setModifyDate(LocalDateTime.now());
		student.setMotherFirstName(getMotherFirstName());
		student.setMotherLastName(getMotherLastName());
		student.setMotherMobile(getMotherMobile());
		student.setPhoneNumber(getPhoneNumber());
		student.setUserName(getUserName());

	}
}
