package recipes.user.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import recipes.pattern.usecase.annotation.UseCase;
import recipes.user.model.UserCreate;
import recipes.user.service.UserService;

@UseCase
@RequiredArgsConstructor
public class RegisterNewUserUseCase {

	private final UserService userService;

	public void execute(UserCreate userCreate) {
		userService.createNewUser(userCreate);
	}
}
