package ml.kalanblow.kaladewn.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ml.kalanblow.kaladewn.domain.user.CreateStudentParameters;
import ml.kalanblow.kaladewn.domain.user.Student;
import ml.kalanblow.kaladewn.repository.StudentRepository;
import ml.kalanblow.kaladewn.service.StudentService;

@Service
@Transactional(readOnly = true)
public class StudentServiceImpl implements StudentService {

	private final StudentRepository studentRepository;

	@Autowired
	public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	@Override
	public Optional<Student> getStudent(String fullName) {

		return studentRepository.findByUserName(fullName);
	}

	@Override
	public Student createStudent(CreateStudentParameters parameters) {

		Student student = new Student(parameters.getUserName(), parameters.getBirthday(), LocalDateTime.now(), LocalDateTime.now(), 
				parameters.getGender(), parameters.getPhoneNumber(), parameters.getEmail(), parameters.getAddress());
		return studentRepository.save(student);
	}

}
