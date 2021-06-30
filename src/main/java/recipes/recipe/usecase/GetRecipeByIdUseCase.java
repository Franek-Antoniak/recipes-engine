package recipes.recipe.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import recipes.recipe.Recipe;
import recipes.recipe.RecipeService;
import recipes.annotations.UseCase;

@UseCase
@RequiredArgsConstructor
public class GetRecipeByIdUseCase {

    private final RecipeService recipeService;

    public ResponseEntity<Recipe> execute(long id) {
        return ResponseEntity.ok(recipeService.getRecipeById(id));
    }
}
