package recipes.recipe.service.usecase;

import lombok.RequiredArgsConstructor;
import recipes.pattern.usecase.annotation.UseCase;
import recipes.recipe.Recipe;
import recipes.recipe.service.RecipeService;

@UseCase
@RequiredArgsConstructor
public class DeleteRecipeByIdUseCase {

	private final RecipeService recipeService;
	private final GetRecipeByIdUseCase getRecipeByIdUseCase;

	public void execute(long id) {
		Recipe recipe = getRecipeByIdUseCase.execute(id);
		recipeService.deleteRecipe(recipe);
	}
}
