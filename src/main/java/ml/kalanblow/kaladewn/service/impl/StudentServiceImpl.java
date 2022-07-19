package ml.kalanblow.kaladewn.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import ml.kalanblow.kaladewn.domain.user.CreateStudentParameters;
import ml.kalanblow.kaladewn.domain.user.EditStudentParameters;
import ml.kalanblow.kaladewn.domain.user.KaladewnUtility;
import ml.kalanblow.kaladewn.domain.user.Student;
import ml.kalanblow.kaladewn.domain.user.UserName;
import ml.kalanblow.kaladewn.repository.SchoolRepository;
import ml.kalanblow.kaladewn.repository.StudentRepository;
import ml.kalanblow.kaladewn.service.StudentService;

@Service
@Transactional
@Slf4j
public class StudentServiceImpl implements StudentService {

	private final StudentRepository studentRepository;

	private final SchoolRepository schoolRepository;

	@Autowired
	public StudentServiceImpl(StudentRepository studentRepository, SchoolRepository schoolRepository) {
		super();
		this.studentRepository = studentRepository;
		this.schoolRepository = schoolRepository;
	}

	/**
	 * @param fullName
	 * @return student with a full name
	 */
	@Override
	public Optional<Student> getStudent(UserName fullName) {

		log.info("Find student by name:{}", studentRepository.findByUserName(fullName));
		return studentRepository.findByUserName(fullName);
	}

	/**
	 * @param parameters
	 * @return new Student
	 */
	@Override
	public Student createStudent(CreateStudentParameters parameters) {

		var ineNumber = KaladewnUtility.generatingandomAlphaNumericStringWithFixedLength();

		var student = new Student();
		student.setUserName(parameters.getUserName());
		student.setGender(parameters.getGender());
		student.setBirthDate(parameters.getBirthday());
		student.setEmail(parameters.getEmail());
		student.setIneNumber(ineNumber);

		student.setMotherFirstName(parameters.getMotherFirstName());
		student.setMotherLastName(parameters.getMotherLastName());
		student.setMotherMobile(parameters.getMotherMobile());

		student.setFatherLastName(parameters.getFatherLastName());
		student.setFatherFirstName(parameters.getFatherFirstName());
		student.setFatherMobile(parameters.getFatherMobile());

		student.setAddress(parameters.getAddress());
		student.setPhoneNumber(parameters.getPhoneNumber());
		student.setSchool(schoolRepository.findAll().get(0));
		log.info("Find student by name:{}", studentRepository.save(student));
		return studentRepository.save(student);
	}

	@Override
	public Page<Student> geytStudents(Pageable pageable) {

		return studentRepository.findAll(pageable);
	}

	@Override
	public Optional<Student> getStudent(Long id) {

		return studentRepository.findById(id);
	}

	@Override
	public Optional<Student> getStudentByIneNumber(String ineNumber) {

		return studentRepository.findByIneNumber(ineNumber);
	}

	@Override
	public Student editStudent(Long id, EditStudentParameters edit) {

		Optional<Student> stOptional = studentRepository.findById(id);
		stOptional.get().setAddress(edit.getAddress());
		stOptional.get().setBirthDate(edit.getBirthday());
		stOptional.get().setCreatedDate(LocalDateTime.now());
		stOptional.get().setEmail(edit.getEmail());
		stOptional.get().setFatherFirstName(edit.getFatherFirstName());
		stOptional.get().setFatherLastName(edit.getFatherLastName());
		stOptional.get().setFatherMobile(edit.getFatherMobile());
		stOptional.get().setGender(edit.getGender());
		stOptional.get().setIneNumber(edit.getStudentIneNumber());
		stOptional.get().setModifyDate(LocalDateTime.now());
		stOptional.get().setMotherFirstName(edit.getMotherFirstName());
		stOptional.get().setMotherLastName(edit.getMotherLastName());
		stOptional.get().setMotherMobile(edit.getMotherMobile());
		stOptional.get().setPhoneNumber(edit.getPhoneNumber());
		//stOptional.get().setSchool(schoolRepository.findAll().get(0));
		stOptional.get().setUserName(edit.getUserName());
		studentRepository.save(stOptional.get());
		return stOptional.get();
	}

	@Override
	public void delete(Long id) {
		studentRepository.deleteById(id);
	}

	@Override
	public void deleteAllStudent() {

		studentRepository.deleteAll();

	}

}
