package recipes.recipe.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import recipes.pattern.usecase.annotation.UseCase;
import recipes.recipe.Recipe;
import recipes.recipe.mapper.RecipeReadMapper;
import recipes.recipe.model.RecipeRead;
import recipes.recipe.service.RecipeService;

@UseCase
@RequiredArgsConstructor
public class GetRecipeByIdUseCase {

	private final RecipeService recipeService;
	private final RecipeReadMapper recipeReadMapper;

	public ResponseEntity<RecipeRead> execute(long id) {
		Recipe recipe = recipeService.getRecipeById(id);
		RecipeRead recipeRead = recipeReadMapper.toRecipeRead(recipe);
		return ResponseEntity.ok(recipeRead);
	}
}
