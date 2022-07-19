package ml.kalanblow.kaladewn.service;

import java.util.Optional;

import ml.kalanblow.kaladewn.domain.user.Email;
import ml.kalanblow.kaladewn.domain.user.PhoneNumber;
import ml.kalanblow.kaladewn.domain.user.User;
import ml.kalanblow.kaladewn.domain.user.UserName;

public interface UserService {

	Optional<User> findByEmail(Email email);

	Optional<User> findByUserName(UserName userName);

	Optional<User> findByPhoneNumber(PhoneNumber phoneNumber);
	
	
}
