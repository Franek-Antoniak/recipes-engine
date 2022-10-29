package recipes.user.service.usecase;

import lombok.RequiredArgsConstructor;
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
