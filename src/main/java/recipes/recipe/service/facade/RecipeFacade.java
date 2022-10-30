package recipes.recipe.service.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import recipes.recipe.Recipe;
import recipes.recipe.model.RecipeCreate;
import recipes.recipe.model.RecipeRead;
import recipes.recipe.model.RecipeUpdate;
import recipes.recipe.model.mapper.RecipeReadMapper;
import recipes.recipe.service.usecase.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class RecipeFacade {

	private final CreateNewRecipeUseCase createNewRecipeUseCase;
	private final GetLatestRecipeUseCase getLatestRecipeUseCase;
	private final GetRecipeByIdUseCase getRecipeByIdUseCase;
	private final DeleteRecipeByIdUseCase deleteRecipeByIdUseCase;
	private final UpdateRecipeByIdUseCase updateRecipeByIdUseCase;
	private final RecipeReadMapper recipeReadMapper;
	private final GetAllRecipesByCategoryAndIngredientsUseCase getAllByCategoryAndIngredients;
	private final GetAllRecipesByCategoryDateDscUseCase getAllByCategory;
	private final GetAllRecipesByIngredientsDateDscUseCase getALlByIngredients;
	private final GetAllRecipesWithRightAuthorisationUseCase getAllRecipesWithRightAuthorisationUseCase;

	public ResponseEntity<Recipe.ID> postRecipe(RecipeCreate recipeCreate) {
		return createNewRecipeUseCase.execute(recipeCreate);
	}

	@SuppressWarnings("unused")
	public ResponseEntity<Recipe> getLatestRecipe() {
		return getLatestRecipeUseCase.execute();
	}


	public RecipeRead getRecipeById(long id) {
		Recipe recipe = getRecipeByIdUseCase.execute(id);
		return recipeReadMapper.toRecipeRead(recipe);
	}

	public void deleteRecipeById(long id) {
		deleteRecipeByIdUseCase.execute(id);
	}

	public void updateRecipeById(long id, RecipeUpdate recipeUpdate) {
		updateRecipeByIdUseCase.execute(id, recipeUpdate);
	}

	public List<RecipeRead> searchRecipes(Optional<String> category, List<String> ingredients) {
		List<Recipe> result = Optional.ofNullable(ingredients == null || ingredients.isEmpty() ? null : ingredients)
		                              .map(i -> category.map(c -> getAllByCategoryAndIngredients.execute(c, i))
		                                                .orElseGet(() -> getALlByIngredients.execute(i)))
		                              .orElseGet(() -> category.map(getAllByCategory::execute)
		                                                       .orElse(List.of()));
		result = getAllRecipesWithRightAuthorisationUseCase.execute(result);
		return result.stream()
		             .map(recipeReadMapper::toRecipeRead)
		             .collect(Collectors.toList());
	}
}
