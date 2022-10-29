package recipes.recipe.service.usecase;

import lombok.RequiredArgsConstructor;
import recipes.pattern.usecase.annotation.UseCase;
import recipes.recipe.Recipe;
import recipes.recipe.service.RecipeService;

import java.util.List;

@UseCase
@RequiredArgsConstructor
public class GetAllRecipesByCategoryAndIngredientsUseCase {
	private final RecipeService recipeService;

	public List<Recipe> execute(String category, List<String> ingredients) {
		return recipeService.getAllRecipesByCategoryAndIngredients(category, ingredients);
	}
}


