package ml.kalanblow.kaladewn.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ml.kalanblow.kaladewn.domain.user.Email;
import ml.kalanblow.kaladewn.domain.user.PhoneNumber;
import ml.kalanblow.kaladewn.domain.user.User;
import ml.kalanblow.kaladewn.domain.user.UserName;

public interface UserService {

	Optional<User> findByEmail(Email email);

	boolean userWithEmailExists(Email email);

	Optional<User> findByUserName(UserName userName);

	Optional<User> findByPhoneNumber(PhoneNumber phoneNumber);

	Optional<User> getUser(Long userId);

	Page<User> getUsers(Pageable pageable);

	void delete(Long id);

	void deleteAllUser();

}
