package recipes.recipe.service.usecase;

import lombok.RequiredArgsConstructor;
import recipes.pattern.usecase.annotation.UseCase;
import recipes.recipe.Recipe;
import recipes.user.User;
import recipes.user.service.facade.UserFacade;

@UseCase
@RequiredArgsConstructor
public class SetAuthorOfRecipeUseCase {
	private final UserFacade userFacade;

	public void execute(Recipe recipe) {
		User author = userFacade.getCurrentUser();
		recipe.setAuthor(author);
	}
}
