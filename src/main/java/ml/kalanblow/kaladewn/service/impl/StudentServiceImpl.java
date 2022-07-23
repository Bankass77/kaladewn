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
import ml.kalanblow.kaladewn.domain.user.Email;
import ml.kalanblow.kaladewn.domain.user.KaladewnUtility;
import ml.kalanblow.kaladewn.domain.user.PhoneNumber;
import ml.kalanblow.kaladewn.domain.user.Student;
import ml.kalanblow.kaladewn.domain.user.User;
import ml.kalanblow.kaladewn.domain.user.UserName;
import ml.kalanblow.kaladewn.exception.EntityType;
import ml.kalanblow.kaladewn.exception.ExceptionType;
import ml.kalanblow.kaladewn.exception.KaladewnManagementException;
import ml.kalanblow.kaladewn.repository.SchoolRepository;
import ml.kalanblow.kaladewn.repository.StudentRepository;
import ml.kalanblow.kaladewn.repository.UserRepository;
import ml.kalanblow.kaladewn.service.StudentService;

@Service
@Transactional
@Slf4j
public class StudentServiceImpl implements StudentService {

	private final StudentRepository studentRepository;

	private final UserRepository userRepository;

	private final SchoolRepository schoolRepository;

	@Autowired
	public StudentServiceImpl(
			 StudentRepository studentRepository,  SchoolRepository schoolRepository,
			UserRepository userRepository) {
		super();
		this.studentRepository = studentRepository;
		this.schoolRepository = schoolRepository;
		this.userRepository = userRepository;
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
		student.setModifyDate(LocalDateTime.now());
		student.setCreatedDate(LocalDateTime.now());
		student.setPhoneNumber(parameters.getMotherMobile());
		student.setAddress(parameters.getAddress());

		student.setMotherFirstName(parameters.getMotherFirstName());
		student.setMotherLastName(parameters.getMotherLastName());
		student.setMotherMobile(parameters.getMotherMobile());

		student.setFatherLastName(parameters.getFatherLastName());
		student.setFatherFirstName(parameters.getFatherFirstName());
		student.setFatherMobile(parameters.getFatherMobile());

		student.setSchool(schoolRepository.findAll().get(0));
		log.info("Find student by name:{}", userRepository.save(student));
		return studentRepository.save(student);
	}

	@Override
	public Optional<Student> getStudentByIneNumber(String ineNumber) {

		return studentRepository.findByIneNumber(ineNumber);
	}

	@Override
	public Student editStudent(Long id, EditStudentParameters edit) {

		Student stOptional = studentRepository.findById(id).orElseThrow(() -> new KaladewnManagementException()
				.throwException(EntityType.STUDENT, ExceptionType.ENTITY_NOT_FOUND, String.valueOf(id)));

		stOptional.setAddress(edit.getAddress());
		stOptional.setBirthDate(edit.getBirthday());
		stOptional.setCreatedDate(LocalDateTime.now());
		stOptional.setEmail(edit.getEmail());
		stOptional.setFatherFirstName(edit.getFatherFirstName());
		stOptional.setFatherLastName(edit.getFatherLastName());
		stOptional.setFatherMobile(edit.getFatherMobile());
		stOptional.setGender(edit.getGender());
		stOptional.setIneNumber(edit.getStudentIneNumber());
		stOptional.setModifyDate(LocalDateTime.now());
		stOptional.setMotherFirstName(edit.getMotherFirstName());
		stOptional.setMotherLastName(edit.getMotherLastName());
		stOptional.setMotherMobile(edit.getMotherMobile());
		stOptional.setPhoneNumber(edit.getPhoneNumber());
		stOptional.setUserName(edit.getUserName());
		edit.updateStudent(stOptional);

		return stOptional;
	}

	@Override
	public Optional<User> findByEmail(Email email) {

		return userRepository.findByEmail(email);
	}

	@Override
	public boolean userWithEmailExists(Email email) {

		return userRepository.existsByEmail(email);
	}

	@Override
	public Optional<User> findByUserName(UserName userName) {

		return userRepository.findByUserName(userName);
	}

	@Override
	public Optional<User> findByPhoneNumber(PhoneNumber phoneNumber) {

		return userRepository.findByPhoneNumber(phoneNumber);
	}

	@Override
	public Optional<User> getUser(Long userId) {

		return userRepository.findById(userId);
	}

	@Override
	public Page<User> getUsers(Pageable pageable) {

		return userRepository.findAll(pageable);
	}

	@Override
	public void delete(Long id) {
		userRepository.deleteById(id);
		
	}

	@Override
	public void deleteAllUser() {
		userRepository.deleteAll();
		
	}

}
