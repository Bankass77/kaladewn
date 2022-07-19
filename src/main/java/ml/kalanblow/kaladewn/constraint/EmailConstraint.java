package ml.kalanblow.kaladewn.constraint;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Email(message="Please provide a valid email address")
@Constraint(validatedBy = {})
@Retention(RetentionPolicy.RUNTIME)
@NotEmpty
@Pattern(regexp =  "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$", message = "Invalid Email:le fomat du mail est incorrect")
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE })
public @interface EmailConstraint {

	String message() default "Invalid Email: le format du mail est incorrect";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
