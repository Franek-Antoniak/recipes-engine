package recipes.user.service.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import recipes.user.User;
import recipes.user.model.UserCreate;
import recipes.user.service.usecase.GetCurrentUserUseCase;
import recipes.user.service.usecase.GetUserByNameUseCase;
import recipes.user.service.usecase.RegisterNewUserUseCase;

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
