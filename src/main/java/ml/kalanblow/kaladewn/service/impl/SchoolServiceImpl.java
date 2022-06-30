package ml.kalanblow.kaladewn.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ml.kalanblow.kaladewn.domain.school.School;
import ml.kalanblow.kaladewn.repository.SchoolRepository;
import ml.kalanblow.kaladewn.service.SchoolService;

@Service
@Transactional(readOnly = true)
public class SchoolServiceImpl implements SchoolService {

	private final SchoolRepository schoolRepository;

	@Autowired
	public SchoolServiceImpl(SchoolRepository schoolRepository) {
		super();
		this.schoolRepository = schoolRepository;
	}

	@Override
	public Optional<School> findByName(String name) {

		return schoolRepository.findByName(name);
	}

}
