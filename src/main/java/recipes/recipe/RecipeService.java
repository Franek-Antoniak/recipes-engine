package recipes.recipe;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import recipes.recipe.exception.RecipeNotFoundException;
import recipes.recipe.mapper.RecipeCreateMapper;
import recipes.recipe.mapper.RecipeUpdateMapper;
import recipes.recipe.model.RecipeCreate;
import recipes.recipe.model.RecipeUpdate;
import recipes.security.AuthenticationFacade;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RecipeService {

	private final RecipeRepository recipeRepository;
	private final RecipeCreateMapper recipeCreateMapper;
	private final RecipeUpdateMapper recipeUpdateMapper;
	private final AuthenticationFacade authenticationFacade;

	public Long createRecipe(RecipeCreate recipeCreate) {
		Recipe recipe = recipeCreateMapper.toRecipe(recipeCreate);
		recipeRepository.save(recipe);
		return recipe.getId();
	}

	public Recipe getLatestRecipe() {
		Optional<Recipe> recipe = recipeRepository.findTopByOrderByIdDesc();
		return recipe.orElseThrow(RecipeNotFoundException::new);
	}

	public void deleteRecipeById(long id) {
		Recipe recipe = getRecipeById(id);
		checkAuthorizationOfRecipe(recipe);
		recipeRepository.delete(recipe);
	}

	public Recipe getRecipeById(long id) {
		Optional<Recipe> recipe = recipeRepository.findById(id);
		return recipe.orElseThrow(RecipeNotFoundException::new);
	}

	public void checkAuthorizationOfRecipe(Recipe recipe) {
		// Authorization - throw if user isn't author of recipe
		authenticationFacade.throwIfUserIsNotAuthorised(recipe.getAuthor()
		                                                      .getUsername());
	}

	public void updateRecipeById(long id, RecipeUpdate recipeUpdate) {
		Recipe recipe = getRecipeById(id);
		checkAuthorizationOfRecipe(recipe);
		recipeUpdateMapper.updateRecipe(recipeUpdate, recipe);
		recipeRepository.save(recipe);
	}

	public List<Recipe> getAllRecipesByCategoryDateDsc(String category) {
		return recipeRepository.findAllByCategoryIgnoreCaseOrderByDateDesc(category);
	}

	public List<Recipe> getAllRecipesByNameDateDsc(String category) {
		return recipeRepository.findAllByNameContainingIgnoreCaseOrderByDateDesc(category);
	}
}
