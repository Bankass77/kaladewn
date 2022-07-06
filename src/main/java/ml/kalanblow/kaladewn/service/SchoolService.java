package ml.kalanblow.kaladewn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;

import ml.kalanblow.kaladewn.domain.school.School;
import ml.kalanblow.kaladewn.domain.user.Address;
import ml.kalanblow.kaladewn.domain.user.CreateSchoolParameters;
import ml.kalanblow.kaladewn.domain.user.EditSchoolParameters;
import ml.kalanblow.kaladewn.domain.user.Email;
import ml.kalanblow.kaladewn.domain.user.PhoneNumber;

public interface SchoolService {

	School createNewSchool(CreateSchoolParameters parameters);

	School editSchool(Long id  ,EditSchoolParameters editSchoolParameters);

	Optional<School> findByName(String name);

	Optional<School> findByPhoneNumber(PhoneNumber phoneNumber);

	Optional<School> findByAddress(Address address);

	Optional<School> findByEmail(Email email);

	void deleteScholl(long id);

	void deleteAllSchools();

	List<School> getAllSchoolList(String name, Pageable pageable);
}
