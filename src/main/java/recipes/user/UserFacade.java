package recipes.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import recipes.user.model.UserCreate;
import recipes.user.usecase.RegisterNewUserUseCase;

@Component
@RequiredArgsConstructor
public class UserFacade {
	private final RegisterNewUserUseCase registerNewUserUseCase;

	public ResponseEntity<String> registerNewUser(UserCreate userCreate) {
		return registerNewUserUseCase.execute(userCreate);
	}
}
