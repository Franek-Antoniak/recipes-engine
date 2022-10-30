package recipes.recipe.service.usecase;

import lombok.RequiredArgsConstructor;
import recipes.pattern.usecase.annotation.UseCase;
import recipes.recipe.Recipe;
import recipes.security.authentication.facade.AuthenticationFacade;

import java.util.List;
import java.util.stream.Collectors;

@UseCase
@RequiredArgsConstructor
public class GetAllRecipesWithRightAuthorisationUseCase {
	private final AuthenticationFacade authenticationFacade;

	public List<Recipe> execute(List<Recipe> recipes) {
		return recipes.stream()
		              .filter(recipe -> recipe.getAuthor()
		                                      .getUsername()
		                                      .equals(authenticationFacade.getAuthentication()
		                                                                  .getName()))
		              .collect(Collectors.toList());
	}
}
