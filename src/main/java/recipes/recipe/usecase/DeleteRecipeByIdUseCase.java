package recipes.recipe.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import recipes.recipe.RecipeService;
import recipes.annotations.UseCase;

@UseCase
@RequiredArgsConstructor
public class DeleteRecipeByIdUseCase {

    private final RecipeService recipeService;

    public ResponseEntity<String> execute(long id) {
        recipeService.deleteRecipeById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .build();
    }
}
