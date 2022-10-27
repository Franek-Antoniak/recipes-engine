package recipes.user.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import recipes.user.User;
import recipes.user.model.UserCreate;
import recipes.user.usecase.GetUserByNameUseCase;
import recipes.user.usecase.RegisterNewUserUseCase;

@Component
@RequiredArgsConstructor
public class UserFacade {
	private final RegisterNewUserUseCase registerNewUserUseCase;
	private final GetUserByNameUseCase getUserByNameUseCase;

	public ResponseEntity<String> registerNewUser(UserCreate userCreate) {
		return registerNewUserUseCase.execute(userCreate);
	}

	public User getUserByName(String username) {
		return getUserByNameUseCase.execute(username);
	}
}
