package recipes.recipe.service.usecase;

import lombok.RequiredArgsConstructor;
import recipes.pattern.usecase.annotation.UseCase;
import recipes.recipe.Recipe;
import recipes.recipe.service.RecipeService;

/*
	Get recipe by id if exists and author of recipe is the same as the logged-in user.
 */
@UseCase
@RequiredArgsConstructor
public class GetRecipeByIdUseCase {

	private final RecipeService recipeService;
	private final CheckRecipeAuthorityUseCase checkRecipeAuthorityUseCase;

	public Recipe execute(long id) {
		Recipe recipe = recipeService.getRecipeById(id);
		checkRecipeAuthorityUseCase.execute(recipe);
		return recipe;
	}
}
