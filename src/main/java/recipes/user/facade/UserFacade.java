package recipes.user.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import recipes.user.User;
import recipes.user.model.UserCreate;
import recipes.user.usecase.GetCurrentUserUseCase;
import recipes.user.usecase.GetUserByNameUseCase;
import recipes.user.usecase.RegisterNewUserUseCase;

@Component
@RequiredArgsConstructor
public class UserFacade {
	private final RegisterNewUserUseCase registerNewUserUseCase;
	private final GetUserByNameUseCase getUserByNameUseCase;
	private final GetCurrentUserUseCase getCurrentUserUseCase;

	public void registerNewUser(UserCreate userCreate) {
		registerNewUserUseCase.execute(userCreate);
	}

	@SuppressWarnings("unused")
	public User getUserByName(String username) {
		return getUserByNameUseCase.execute(username);
	}

	public User getCurrentUser() {
		return getCurrentUserUseCase.execute();
	}
}
