package recipes.recipe.usecase;

import lombok.RequiredArgsConstructor;
import recipes.pattern.usecase.annotation.UseCase;
import recipes.recipe.Recipe;
import recipes.recipe.mapper.RecipeReadMapper;
import recipes.recipe.model.RecipeRead;
import recipes.recipe.service.RecipeService;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@UseCase
@RequiredArgsConstructor
public class GetAllRecipesByNameDateDscUseCase {

	private final RecipeService recipeService;
	private final RecipeReadMapper recipeReadMapper;

	public List<RecipeRead> execute(String name) {
		List<Recipe> recipes = recipeService.getAllRecipesByNameDateDsc(name.toLowerCase(Locale.ROOT));
		return recipes.stream()
		              .map(recipeReadMapper::toRecipeRead)
		              .collect(Collectors.toList());
	}
}
