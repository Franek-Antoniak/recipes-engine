package recipes.recipe.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import recipes.annotations.UseCase;
import recipes.recipe.RecipeService;
import recipes.recipe.model.RecipeUpdate;

@UseCase
@RequiredArgsConstructor
public class UpdateRecipeByIdUseCase {

	private final RecipeService recipeService;

	public ResponseEntity<String> execute(long id, RecipeUpdate recipeUpdate) {
		recipeService.updateRecipeById(id, recipeUpdate);
		return ResponseEntity.status(HttpStatus.NO_CONTENT)
		                     .build();
	}
}
