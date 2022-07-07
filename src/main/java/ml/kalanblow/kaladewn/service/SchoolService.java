package ml.kalanblow.kaladewn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ml.kalanblow.kaladewn.domain.school.CreateSchoolParameters;
import ml.kalanblow.kaladewn.domain.school.EditSchoolParameters;
import ml.kalanblow.kaladewn.domain.school.School;
import ml.kalanblow.kaladewn.domain.user.Address;
import ml.kalanblow.kaladewn.domain.user.Email;
import ml.kalanblow.kaladewn.domain.user.PhoneNumber;

public interface SchoolService {

	Optional<School> getSchool(Long id);
	School createNewSchool(CreateSchoolParameters parameters);

	School editSchool(Long id  ,EditSchoolParameters editSchoolParameters);

	Optional<School> findByName(String name);

	Optional<School> findByPhoneNumber(PhoneNumber phoneNumber);

	Optional<School> findByAddress(Address address);

	Optional<School> findByEmail(Email email);

	void deleteScholl(long id);

	void deleteAllSchools();

	Page<School> getAllSchoolList(Pageable pageable);
}
