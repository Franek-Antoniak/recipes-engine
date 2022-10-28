package recipes.user.usecase;

import lombok.RequiredArgsConstructor;
import recipes.pattern.usecase.annotation.UseCase;
import recipes.security.authentication.facade.AuthenticationFacade;
import recipes.user.User;
import recipes.user.service.UserService;

@UseCase
@RequiredArgsConstructor
public class GetCurrentUserUseCase {
	private final UserService userService;
	private final AuthenticationFacade authenticationFacade;

	public User execute() {
		String username = authenticationFacade.getAuthentication().getName();
		return userService.getUserByName(username);
	}
}
