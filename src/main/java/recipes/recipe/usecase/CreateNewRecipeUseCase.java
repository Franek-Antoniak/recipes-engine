package recipes.recipe.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import recipes.annotations.UseCase;
import recipes.recipe.Recipe;
import recipes.recipe.RecipeService;
import recipes.recipe.model.RecipeCreate;

@UseCase
@RequiredArgsConstructor
public class CreateNewRecipeUseCase {

	private final RecipeService recipeService;

	public ResponseEntity<Recipe.ID> execute(RecipeCreate recipeCreate) {
		return ResponseEntity.ok(new Recipe.ID(recipeService.createRecipe(recipeCreate)));
	}
}
