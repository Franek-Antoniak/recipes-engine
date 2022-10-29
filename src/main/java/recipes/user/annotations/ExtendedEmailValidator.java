package recipes.user.annotations;

import javax.validation.Constraint;
import javax.validation.constraints.Email;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Email(
		message = "Email address doesn't match the pattern",
		regexp = "^[A-Za-z0-9+_.-]+@(.+)$"
)
@Target({METHOD, FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = {})
public @interface ExtendedEmailValidator {
	String message() default "Email address doesn't match the pattern";

	Class<?>[] groups() default {};

	Class<? extends javax.validation.Payload>[] payload() default {};
}