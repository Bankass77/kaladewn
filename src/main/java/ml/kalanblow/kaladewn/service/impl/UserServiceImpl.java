package ml.kalanblow.kaladewn.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import ml.kalanblow.kaladewn.domain.user.Email;
import ml.kalanblow.kaladewn.domain.user.PhoneNumber;
import ml.kalanblow.kaladewn.domain.user.User;
import ml.kalanblow.kaladewn.domain.user.UserName;
import ml.kalanblow.kaladewn.repository.UserRepository;
import ml.kalanblow.kaladewn.service.UserService;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
		
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

	@Override
	public boolean userWithEmailExists(Email email) {
		return userRepository.existsByEmail(email);
	}

	@Override
	public Optional<User> getUser(Long userId) {

		return userRepository.findById(userId);
	}

	@Override
	public Page<User> getUsers(Pageable pageable) {

		return userRepository.findAll(pageable);
	}

	@Override
	public void delete(Long id) {
		userRepository.deleteById(id);
		
	}

	@Override
	public void deleteAllUser() {
		userRepository.deleteAll();
	}

}
