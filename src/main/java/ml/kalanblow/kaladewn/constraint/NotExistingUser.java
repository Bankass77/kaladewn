package ml.kalanblow.kaladewn.constraint;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import ml.kalanblow.kaladewn.validation.NotExistingUserValidator;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NotExistingUserValidator.class)
public @interface NotExistingUser {
	
	String message() default "{UserAlreadyExisting}";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload () default {}; 

}
