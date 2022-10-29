package recipes.recipe.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import recipes.recipe.Recipe;
import recipes.recipe.exception.RecipeNotFoundException;
import recipes.recipe.repository.RecipeRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RecipeService {

	private final RecipeRepository recipeRepository;

	public Recipe.ID createRecipe(Recipe recipe) {
		recipeRepository.save(recipe);
		return recipe.getRecipeID();
	}

	public Recipe getLatestRecipe() {
		Optional<Recipe> recipe = recipeRepository.findTopByOrderByIdDesc();
		return recipe.orElseThrow(RecipeNotFoundException::new);
	}

	public void deleteRecipe(Recipe recipe) {
		recipeRepository.delete(recipe);
	}

	public Recipe getRecipeById(long id) {
		Optional<Recipe> recipe = recipeRepository.findById(id);
		return recipe.orElseThrow(RecipeNotFoundException::new);
	}

	public List<Recipe> getAllRecipesByCategory(String category) {
		return recipeRepository.findAllByCategoryIgnoreCaseOrderByDateDesc(category);
	}

	public List<Recipe> getAllRecipesByNameDateDsc(String category) {
		return recipeRepository.findAllByNameContainingIgnoreCaseOrderByDateDesc(category);
	}

	public void saveRecipe(Recipe recipe) {
		recipeRepository.save(recipe);
	}

	public List<Recipe> getAllRecipesByCategoryAndIngredients(String category, List<String> ingredients) {
		return recipeRepository.findAllByCategoryIgnoreCaseAndIngredientsIgnoreCaseInOrderByDateDesc(
				category, ingredients);
	}

	public List<Recipe> getAllRecipesByIngredients(List<String> ingredients) {
		return recipeRepository.findAllByIngredientsInOrderByDateDesc(ingredients);
	}
}
