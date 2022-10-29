package recipes.user.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import recipes.user.annotations.ExtendedEmailValidator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
public class UserCreate {

	@ApiModelProperty(
			notes = "The user's email address",
			required = true
	)
	@NotBlank(message = "Email cannot be blank")
	@ExtendedEmailValidator
	private String email;

	@ApiModelProperty(
			notes = "The user's password",
			required = true
	)
	@NotBlank(message = "Password cannot be blank")
	@Pattern(
			regexp = "\\w{8,}",
			message = "Password should contain at least 8 characters"
	)
	private String password;
}
