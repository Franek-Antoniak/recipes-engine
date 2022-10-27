package recipes.user.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import recipes.user.annotations.ExtendedEmailValidator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
public class UserCreate {
	@NotBlank(message = "Email cannot be blank")
	@ExtendedEmailValidator
	private String email;
	@NotBlank(message = "Password cannot be blank")
	@Pattern(regexp = "\\w{8,}", message = "Password should contain at least 8 characters")
	private String password;
}
