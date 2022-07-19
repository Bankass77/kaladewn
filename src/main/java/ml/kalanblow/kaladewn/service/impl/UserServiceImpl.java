package ml.kalanblow.kaladewn.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import ml.kalanblow.kaladewn.domain.user.Email;
import ml.kalanblow.kaladewn.domain.user.PhoneNumber;
import ml.kalanblow.kaladewn.domain.user.User;
import ml.kalanblow.kaladewn.domain.user.UserName;
import ml.kalanblow.kaladewn.repository.SchoolRepository;
import ml.kalanblow.kaladewn.repository.UserRepository;
import ml.kalanblow.kaladewn.service.UserService;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private final SchoolRepository schoolRepository;

	@Autowired
	public UserServiceImpl(UserRepository userRepository,SchoolRepository schoolRepository) {
		super();
		this.userRepository = userRepository;
		this.schoolRepository=schoolRepository;
	}

	@Override
	public Optional<User> findByEmail(Email email) {
		log.info("User By mail: {}", userRepository.findByEmail(email));
		return userRepository.findByEmail(email);
	}

	@Override
	public Optional<User> findByUserName(UserName userName) {

		return userRepository.findByUserName(userName);
	}

	@Override
	public Optional<User> findByPhoneNumber(PhoneNumber phoneNumber) {

		return userRepository.findByPhoneNumber(phoneNumber);
	}

	

}
