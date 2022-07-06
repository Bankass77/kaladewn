package ml.kalanblow.kaladewn.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ml.kalanblow.kaladewn.domain.school.School;
import ml.kalanblow.kaladewn.domain.user.Address;
import ml.kalanblow.kaladewn.domain.user.Email;
import ml.kalanblow.kaladewn.domain.user.PhoneNumber;

@Repository
public interface SchoolRepository extends JpaRepository<School, Long> {

	Optional<School> findByName(String name);

	Optional<School> findByPhoneNumber(PhoneNumber phoneNumber);

	Optional<School> findByAddress(Address address);

	Optional<School> findByEmail(Email email);

	List<School> findAllByName(String name, Pageable pageable);

}
