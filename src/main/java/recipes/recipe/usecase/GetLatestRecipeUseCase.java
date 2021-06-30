package recipes.recipe.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import recipes.recipe.Recipe;
import recipes.recipe.RecipeService;
import recipes.annotations.UseCase;

@UseCase
@RequiredArgsConstructor
public class GetLatestRecipeUseCase {

    private final RecipeService recipeService;

    public ResponseEntity<Recipe> execute() {
        return ResponseEntity.ok(recipeService.getLatestRecipe());
    }
}
