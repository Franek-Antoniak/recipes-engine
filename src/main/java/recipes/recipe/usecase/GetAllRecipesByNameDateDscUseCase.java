package recipes.recipe.usecase;

import lombok.RequiredArgsConstructor;
import recipes.annotations.UseCase;
import recipes.recipe.Recipe;
import recipes.recipe.RecipeService;

import java.util.List;
import java.util.Locale;

@UseCase
@RequiredArgsConstructor
public class GetAllRecipesByNameDateDscUseCase {

    private final RecipeService recipeService;

    public List<Recipe> execute(String name) {
        return recipeService.getAllRecipesByNameDateDsc(name.toLowerCase(Locale.ROOT));
    }
}
