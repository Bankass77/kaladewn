package ml.kalanblow.kaladewn.service.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import ml.kalanblow.kaladewn.domain.school.CreateSchoolParameters;
import ml.kalanblow.kaladewn.domain.school.EditSchoolParameters;
import ml.kalanblow.kaladewn.domain.school.School;
import ml.kalanblow.kaladewn.domain.user.Address;
import ml.kalanblow.kaladewn.domain.user.Email;
import ml.kalanblow.kaladewn.domain.user.PhoneNumber;
import ml.kalanblow.kaladewn.exception.EntityType;
import ml.kalanblow.kaladewn.exception.ExceptionType;
import ml.kalanblow.kaladewn.exception.KaladewnManagementException;
import ml.kalanblow.kaladewn.repository.SchoolRepository;
import ml.kalanblow.kaladewn.service.SchoolService;
import ml.kalanblow.kaladewn.service.StudentService;

@Service
@Transactional
@Slf4j
public class SchoolServiceImpl implements SchoolService {

	private final SchoolRepository schoolRepository;
	private final StudentService studentService;

	@Autowired
	public SchoolServiceImpl(SchoolRepository schoolRepository, StudentService studentService) {
		super();
		this.schoolRepository = schoolRepository;
		this.studentService = studentService;
	}

	/**
	 * @param name
	 * @return school name
	 */
	@Override
	public Optional<School> findByName(String name) {

		log.debug("find school by Name:", name);
		return schoolRepository.findByName(name);
	}

	@Override
	public Optional<School> findByPhoneNumber(PhoneNumber phoneNumber) {

		return schoolRepository.findByPhoneNumber(phoneNumber);
	}

	@Override
	public Optional<School> findByAddress(Address address) {

		log.info("School Address: {}", schoolRepository.findByAddress(address));
		return schoolRepository.findByAddress(address);
	}

	@Override
	public Optional<School> findByEmail(Email email) {

		log.info("School Email: {}", schoolRepository.findByEmail(email));
		return schoolRepository.findByEmail(email);
	}

	@Override
	public School createNewSchool(CreateSchoolParameters parameters) {
		String schoolName = parameters.getName();
		String email = parameters.getEmail();
		PhoneNumber phoneNumber = parameters.getPhoneNumber();
		Address address = parameters.getAddress();

		log.info("Creating school {} with student {} ({})", schoolName, email, phoneNumber);
		School school = new School();
		school.setAddress(address);
		school.setEmail(email);
		school.setName(schoolName);
		school.setPhoneNumber(phoneNumber);

		log.info("Creating school {})",schoolRepository.save(school));
		return schoolRepository.save(school);
	}

	@Override
	public School editSchool(Long id, EditSchoolParameters editSchoolParameters) {

		Optional<School> school = Optional.ofNullable(getSchool(id)
				.orElseThrow(() -> new KaladewnManagementException().throwExceptionWithId(EntityType.School,
						ExceptionType.ENTITY_NOT_FOUND, String.valueOf(id), editSchoolParameters.getName())));

		school.get().setName(editSchoolParameters.getName());
		school.get().setPhoneNumber(editSchoolParameters.getPhoneNumber());
		school.get().setEmail(editSchoolParameters.getEmail());
		school.get().setAddress(editSchoolParameters.getAddress());
		log.info("Edit school :{}", school.get());
		return school.get();
	}

	@Override
	public void deleteScholl(long id) {

		Optional<School> schoolId = schoolRepository.findById(id);

		if (schoolId.isPresent()) {
			log.info("Delete school :{}", schoolId.get());
			schoolRepository.deleteById(id);
		}

	}

	@Override
	public void deleteAllSchools() {

		schoolRepository.deleteAll();

	}

	@Override
	public Page<School> getAllSchoolList(Pageable pageable) {
		log.info("School Name: {}", schoolRepository.findAll(pageable));
		return schoolRepository.findAll(pageable);
	}

	@Override
	public Optional<School> getSchool(Long id) {

		log.info("School get id: {}", schoolRepository.findById(id));
		return schoolRepository.findById(id);
	}
}
