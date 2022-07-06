package ml.kalanblow.kaladewn.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ml.kalanblow.kaladewn.domain.user.PhoneNumber;
import ml.kalanblow.kaladewn.domain.user.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	Optional<Student> findStudentByUserId(Long id);

	Optional<Student> findByEmail(String email);

	Optional<Student> findByUserName(String userName);

	Optional<Student> findByPhoneNumber(PhoneNumber number);

}
