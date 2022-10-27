package recipes.recipe.usecase;

import lombok.RequiredArgsConstructor;
import recipes.pattern.usecase.annotation.UseCase;
import recipes.recipe.Recipe;
import recipes.recipe.service.RecipeService;

import java.util.List;
import java.util.Locale;

@UseCase
@RequiredArgsConstructor
public class GetAllRecipesByCategoryDateDscUseCase {

	private final RecipeService recipeService;

	public List<Recipe> execute(String category) {
		return recipeService.getAllRecipesByCategoryDateDsc(category.toLowerCase(Locale.ROOT));
	}
}
