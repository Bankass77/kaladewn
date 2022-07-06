package ml.kalanblow.kaladewn.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import ml.kalanblow.kaladewn.domain.school.School;
import ml.kalanblow.kaladewn.domain.user.Address;
import ml.kalanblow.kaladewn.domain.user.CreateSchoolParameters;
import ml.kalanblow.kaladewn.domain.user.EditSchoolParameters;
import ml.kalanblow.kaladewn.domain.user.Email;
import ml.kalanblow.kaladewn.domain.user.PhoneNumber;
import ml.kalanblow.kaladewn.exception.EntityType;
import ml.kalanblow.kaladewn.exception.ExceptionType;
import ml.kalanblow.kaladewn.exception.KaladewnManagementException;
import ml.kalanblow.kaladewn.repository.SchoolRepository;
import ml.kalanblow.kaladewn.service.SchoolService;

@Service
@Transactional(readOnly = true)
@Slf4j
public class SchoolServiceImpl implements SchoolService {

	private final SchoolRepository schoolRepository;

	@Autowired
	public SchoolServiceImpl(SchoolRepository schoolRepository) {
		super();
		this.schoolRepository = schoolRepository;
	}

	/**
	 * @param name
	 * @return school name
	 */
	@Override
	public Optional<School> findByName(String name) {

		return schoolRepository.findByName(name);
	}

	@Override
	public Optional<School> findByPhoneNumber(PhoneNumber phoneNumber) {

		return schoolRepository.findByPhoneNumber(phoneNumber);
	}

	@Override
	public Optional<School> findByAddress(Address address) {

		return schoolRepository.findByAddress(address);
	}

	@Override
	public Optional<School> findByEmail(Email email) {

		return schoolRepository.findByEmail(email);
	}

	@Override
	public School createNewSchool(CreateSchoolParameters parameters) {
		String schoolName = parameters.getName();
		Email email = parameters.getEmail();
		PhoneNumber phoneNumber = parameters.getPhoneNumber();
		Address address = parameters.getAddress();

		School school = new School(schoolName, address, phoneNumber, email);

		return schoolRepository.save(school);
	}

	@Override
	public School editSchool(Long id, EditSchoolParameters editSchoolParameters) {

		Optional<School> school = Optional.ofNullable(getSchool(id).orElseThrow(() -> new KaladewnManagementException()
				.throwExceptionWithId(EntityType.School, ExceptionType.ENTITY_NOT_FOUND, String.valueOf(id), editSchoolParameters.getName())));
		
		school.get().set(editSchoolParameters.getName());
		school.get().set(editSchoolParameters.getPhoneNumber());
		school.get().set(editSchoolParameters.getEmail());
		school.get().set(editSchoolParameters.getAddress());
		
		
		return school.get();
	}

	@Override
	public void deleteScholl(long id) {

		Optional<School> schoolId = schoolRepository.findById(id);

		if (schoolId.isPresent()) {
			schoolRepository.deleteById(id);
		}

	}

	@Override
	public void deleteAllSchools() {
		
		schoolRepository.deleteAll();

	}

	@Override
	public List<School> getAllSchoolList(String name, Pageable pageable) {

		Pageable pageWithFiveElements = PageRequest.of(1, 5);
		Page<School> allSchool = schoolRepository.findAll(pageWithFiveElements);

		return schoolRepository.findAllByName(name, allSchool.getPageable());
	}

	public Optional<School> getSchool(Long id) {

		return schoolRepository.findById(id);
	}
}
