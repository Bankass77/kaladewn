package ml.kalanblow.kaladewn.service;

import java.util.Optional;

import ml.kalanblow.kaladewn.domain.user.CreateStudentParameters;
import ml.kalanblow.kaladewn.domain.user.EditStudentParameters;
import ml.kalanblow.kaladewn.domain.user.Student;

public interface StudentService extends UserService {

	Optional<Student> getStudentByIneNumber(String ineNumber);

	Student createStudent(CreateStudentParameters parameters);

	Student editStudent(Long id, EditStudentParameters edit);

}
