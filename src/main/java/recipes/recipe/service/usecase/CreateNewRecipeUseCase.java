package recipes.recipe.service.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import recipes.pattern.usecase.annotation.UseCase;
import recipes.recipe.Recipe;
import recipes.recipe.model.RecipeCreate;
import recipes.recipe.model.mapper.RecipeCreateMapper;
import recipes.recipe.service.RecipeService;

@UseCase
@RequiredArgsConstructor
public class CreateNewRecipeUseCase {

	private final RecipeService recipeService;
	private final RecipeCreateMapper recipeCreateMapper;
	private final SetAuthorOfRecipeUseCase setAuthorOfRecipeUseCase;

	public ResponseEntity<Recipe.ID> execute(RecipeCreate recipeCreate) {
		Recipe recipe = recipeCreateMapper.toRecipe(recipeCreate);
		setAuthorOfRecipeUseCase.execute(recipe);
		return ResponseEntity.status(HttpStatus.CREATED)
		                     .body(recipeService.createRecipe(recipe));
	}
}
