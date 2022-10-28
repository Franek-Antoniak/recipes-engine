package recipes.recipe.usecase;

import lombok.RequiredArgsConstructor;
import recipes.pattern.usecase.annotation.UseCase;
import recipes.recipe.Recipe;
import recipes.recipe.model.RecipeCreate;
import recipes.security.authentication.facade.AuthenticationFacade;
import recipes.user.User;
import recipes.user.facade.UserFacade;

@UseCase
@RequiredArgsConstructor
public class SetAuthorOfRecipeUseCase {
	private final UserFacade userFacade;

	public void execute(Recipe recipe) {
		User author = userFacade.getCurrentUser();
		recipe.setAuthor(author);
	}
}
