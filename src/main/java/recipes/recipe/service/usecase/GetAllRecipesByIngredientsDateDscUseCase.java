package recipes.recipe.service.usecase;

import lombok.RequiredArgsConstructor;
import recipes.pattern.usecase.annotation.UseCase;
import recipes.recipe.Recipe;
import recipes.recipe.service.RecipeService;

import java.util.List;

@UseCase
@RequiredArgsConstructor
public class GetAllRecipesByIngredientsDateDscUseCase {
	private final RecipeService recipeService;

	public List<Recipe> execute(List<String> ingredients) {
		return recipeService.getAllRecipesByIngredients(ingredients);
	}
}
