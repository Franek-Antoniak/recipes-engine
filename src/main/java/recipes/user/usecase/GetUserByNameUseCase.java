package recipes.user.usecase;

import lombok.RequiredArgsConstructor;
import recipes.annotations.UseCase;
import recipes.user.User;
import recipes.user.UserService;

@UseCase
@RequiredArgsConstructor
public class GetUserByNameUseCase {

	private final UserService userService;

	public User execute(String username) {
		return userService.findUserByName(username);
	}

}
