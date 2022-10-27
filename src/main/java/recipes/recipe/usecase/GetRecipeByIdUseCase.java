package recipes.recipe.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import recipes.pattern.usecase.annotation.UseCase;
import recipes.recipe.Recipe;
import recipes.recipe.service.RecipeService;

@UseCase
@RequiredArgsConstructor
public class GetRecipeByIdUseCase {

	private final RecipeService recipeService;

	public ResponseEntity<Recipe> execute(long id) {
		return ResponseEntity.ok(recipeService.getRecipeById(id));
	}
}
