package ml.kalanblow.kaladewn.service;

import java.util.Optional;

import ml.kalanblow.kaladewn.domain.user.CreateStudentParameters;
import ml.kalanblow.kaladewn.domain.user.Student;
import ml.kalanblow.kaladewn.domain.user.UserName;

public interface StudentService {

	Optional<Student> getStudent(UserName fullName);

	Student createStudent(CreateStudentParameters parameters);

}
