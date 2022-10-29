package recipes.recipe.service.usecase;

import lombok.RequiredArgsConstructor;
import recipes.pattern.usecase.annotation.UseCase;
import recipes.recipe.Recipe;
import recipes.recipe.exception.UserNotAuthorizedException;
import recipes.security.authentication.facade.AuthenticationFacade;

@UseCase
@RequiredArgsConstructor
public class CheckRecipeAuthorityUseCase {
	private final AuthenticationFacade authenticationFacade;

	public void execute(Recipe recipe) {
		String username = authenticationFacade.getAuthenticationName();
		boolean isAuthorized = recipe.getAuthor()
		                             .getUsername()
		                             .equals(username);
		if (!isAuthorized) {
			throw new UserNotAuthorizedException();
		}
	}

}
