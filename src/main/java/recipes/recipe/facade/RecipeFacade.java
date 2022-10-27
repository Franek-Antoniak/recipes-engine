package recipes.recipe.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import recipes.recipe.Recipe;
import recipes.recipe.exception.TooManyOrNotEnoughMethodArguments;
import recipes.recipe.model.RecipeCreate;
import recipes.recipe.model.RecipeUpdate;
import recipes.recipe.usecase.*;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class RecipeFacade {

	//UseCase
	private final CreateNewRecipeUseCase createNewRecipeUseCase;
	private final GetLatestRecipeUseCase getLatestRecipeUseCase;
	private final GetRecipeByIdUseCase getRecipeByIdUseCase;
	private final DeleteRecipeByIdUseCase deleteRecipeByIdUseCase;
	private final UpdateRecipeByIdUseCase updateRecipeByIdUseCase;
	private final GetAllRecipesByCategoryDateDscUseCase getAllRecipesByCategoryDateDscUseCase;
	private final GetAllRecipesByNameDateDscUseCase getAllRecipesByNameDateDscUseCase;
	private final SetAuthorOfRecipeUseCase setAuthorOfRecipeUseCase;

	public ResponseEntity<Recipe.ID> postRecipe(RecipeCreate recipeCreate) {
		setAuthorOfRecipeUseCase.execute(recipeCreate);
		return createNewRecipeUseCase.execute(recipeCreate);
	}

	@SuppressWarnings("unused")
	public ResponseEntity<Recipe> getLatestRecipe() {
		return getLatestRecipeUseCase.execute();
	}


	public ResponseEntity<Recipe> getRecipeById(long id) {
		return getRecipeByIdUseCase.execute(id);
	}

	public ResponseEntity<String> deleteRecipeById(long id) {
		return deleteRecipeByIdUseCase.execute(id);
	}

	public ResponseEntity<String> updateRecipeById(long id, RecipeUpdate recipeUpdate) {
		return updateRecipeByIdUseCase.execute(id, recipeUpdate);
	}

	public List<Recipe> getAllRecipesCategoryOrNameRestriction(Optional<String> category, Optional<String> name) {
		boolean isBothEmpty = category.isEmpty() && name.isEmpty();
		boolean isBothPresent = category.isPresent() && name.isPresent();
		if (isBothEmpty || isBothPresent) {
			throw new TooManyOrNotEnoughMethodArguments();
		}
		if (category.isPresent()) {
			return getAllRecipesByCategoryDateDscUseCase.execute(category.get());
		}
		return getAllRecipesByNameDateDscUseCase.execute(name.get());
	}
}
