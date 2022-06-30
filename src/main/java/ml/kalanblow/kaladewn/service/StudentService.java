package ml.kalanblow.kaladewn.service;

import java.util.Optional;

import ml.kalanblow.kaladewn.domain.user.CreateStudentParameters;
import ml.kalanblow.kaladewn.domain.user.Student;

public interface StudentService {

	Optional<Student> getStudent(String fullName);

	Student createStudent(CreateStudentParameters parameters);

}
