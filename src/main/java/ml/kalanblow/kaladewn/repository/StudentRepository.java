package ml.kalanblow.kaladewn.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ml.kalanblow.kaladewn.domain.user.Email;
import ml.kalanblow.kaladewn.domain.user.PhoneNumber;
import ml.kalanblow.kaladewn.domain.user.Student;
import ml.kalanblow.kaladewn.domain.user.UserName;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	Optional<Student> findStudentByUserId(Long id);

	Optional<Student> findByEmail(Email email);

	Optional<Student> findByUserName(UserName userName);

	Optional<Student> findByPhoneNumber(PhoneNumber number);
	
	Optional<Student> findByIneNumber (String ineNumber);

}
