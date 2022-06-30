package ml.kalanblow.kaladewn.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ml.kalanblow.kaladewn.domain.school.School;


@Repository
public interface SchoolRepository  extends JpaRepository<School, Long>{
	
	
	Optional<School> findByName(String name);

}
