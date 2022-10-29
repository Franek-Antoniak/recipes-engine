package recipes.recipe.service.usecase;

import lombok.RequiredArgsConstructor;
import recipes.pattern.usecase.annotation.UseCase;
import recipes.recipe.Recipe;
import recipes.recipe.model.RecipeUpdate;
import recipes.recipe.model.mapper.RecipeUpdateMapper;
import recipes.recipe.service.RecipeService;

@UseCase
@RequiredArgsConstructor
public class UpdateRecipeByIdUseCase {

	private final GetRecipeByIdUseCase getRecipeByIdUseCase;
	private final RecipeUpdateMapper recipeUpdateMapper;
	private final RecipeService recipeService;

	public void execute(long id, RecipeUpdate recipeUpdate) {
		Recipe recipe = getRecipeByIdUseCase.execute(id);
		recipeUpdateMapper.updateRecipe(recipeUpdate, recipe);
		recipeService.saveRecipe(recipe);
	}
}
