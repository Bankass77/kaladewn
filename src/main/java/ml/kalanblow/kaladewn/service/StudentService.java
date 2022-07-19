package ml.kalanblow.kaladewn.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ml.kalanblow.kaladewn.domain.user.CreateStudentParameters;
import ml.kalanblow.kaladewn.domain.user.EditStudentParameters;
import ml.kalanblow.kaladewn.domain.user.Student;
import ml.kalanblow.kaladewn.domain.user.UserName;

public interface StudentService {

	Page<Student> geytStudents(Pageable pageable);

	Optional<Student> getStudent(Long id);

	Optional<Student> getStudentByIneNumber(String ineNumber);

	Optional<Student> getStudent(UserName fullName);

	Student createStudent(CreateStudentParameters parameters);

	Student editStudent(Long id, EditStudentParameters edit);

	void delete(Long id);

	void deleteAllStudent();

}
