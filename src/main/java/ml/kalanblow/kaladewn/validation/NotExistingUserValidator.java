package ml.kalanblow.kaladewn.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import ml.kalanblow.kaladewn.constraint.NotExistingUser;
import ml.kalanblow.kaladewn.domain.user.CreateStudentFormData;
import ml.kalanblow.kaladewn.domain.user.Email;
import ml.kalanblow.kaladewn.service.StudentService;
import ml.kalanblow.kaladewn.service.UserService;

public class NotExistingUserValidator implements ConstraintValidator<NotExistingUser, CreateStudentFormData> {

	private final StudentService studentService;

	@Autowired
	public NotExistingUserValidator(StudentService studentService) {
		super();
		this.studentService = studentService;
	}

	public void initialize(NotExistingUser constraint) {

	}

	@Override
	public boolean isValid(CreateStudentFormData value, ConstraintValidatorContext context) {

		if (!StringUtils.isEmpty(value.getEmail()) && studentService.userWithEmailExists(new Email(value.getEmail()))) {

			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate("{UserAlreadyExisting}").addPropertyNode("email")
					.addConstraintViolation();
			return false;
		}
		return true;
	}

}
