package recipes.user.annotations;

import javax.validation.Constraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


@Target({METHOD, FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
@NotBlank(message = "Email cannot be blank")
@Pattern(
		regexp = "^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$",
		message = "Email should be valid"
)
@Constraint(validatedBy = {})
public @interface CustomEmailConstraint {
	String message() default "Email address doesn't match the pattern";

	Class<?>[] groups() default {};

	Class<? extends javax.validation.Payload>[] payload() default {};
}