package ml.kalanblow.kaladewn.service;

import java.util.Optional;

import ml.kalanblow.kaladewn.domain.school.School;

public interface SchoolService {

	
	Optional<School> findByName(String name);
}
