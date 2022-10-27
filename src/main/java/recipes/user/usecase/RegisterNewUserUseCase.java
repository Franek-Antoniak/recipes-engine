package recipes.user.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import recipes.pattern.usecase.annotation.UseCase;
import recipes.user.service.UserService;
import recipes.user.model.UserCreate;

@UseCase
@RequiredArgsConstructor
public class RegisterNewUserUseCase {

	private final UserService userService;

	public ResponseEntity<String> execute(UserCreate userCreate) {
		userService.createNewUser(userCreate);
		return ResponseEntity.ok()
		                     .build();
	}
}
