package ml.kalanblow.kaladewn.repository;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ml.kalanblow.kaladewn.domain.user.Email;
import ml.kalanblow.kaladewn.domain.user.PhoneNumber;
import ml.kalanblow.kaladewn.domain.user.User;
import ml.kalanblow.kaladewn.domain.user.UserName;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByEmail(Email email);

	Optional<User> findByUserName(UserName userName);

	Optional<User> findByPhoneNumber(PhoneNumber phoneNumber);

	@Query("select u from User u")
	Stream<User> streamAll();

}
