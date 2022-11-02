package recipes.recipe.controller;

import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import recipes.recipe.Recipe;
import recipes.recipe.controller.annotation.*;
import recipes.recipe.exception.RecipeNotFoundException;
import recipes.recipe.model.RecipeCreate;
import recipes.recipe.model.RecipeRead;
import recipes.recipe.model.RecipeUpdate;
import recipes.recipe.service.facade.RecipeFacade;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Validated
@RestController
@RequestMapping(path = "/api/recipe")
public class RecipeController {
	private final RecipeFacade recipeFacade;

	@PostRecipeApiAnnotation
	@PostMapping("/new")
	public ResponseEntity<Recipe.ID> postRecipe(
			@ApiParam("Information about the recipe") @Valid @RequestBody RecipeCreate recipeCreate
	                                           ) {
		return recipeFacade.postRecipe(recipeCreate);
	}

	@UpdateRecipeByIdApiAnnotation
	@PutMapping("/{id}")
	public ResponseEntity<Void> updateRecipeById(
			@ApiParam("Recipe id") @PathVariable @Min(1) long id,
			@ApiParam("Update data for recipe") @RequestBody RecipeUpdate recipeUpdate
	                                            ) {
		recipeFacade.updateRecipeById(id, recipeUpdate);
		return ResponseEntity.status(HttpStatus.NO_CONTENT)
		                     .build();
	}

	@DeleteRecipeByIdRecipeApiAnnotation
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteRecipeById(@ApiParam("Recipe id") @PathVariable @Min(1) long id) {
		recipeFacade.deleteRecipeById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT)
		                     .build();
	}

	@GetRecipeByIdApiAnnotation
	@GetMapping("/{id}")
	public ResponseEntity<RecipeRead> getRecipeById(@ApiParam("Recipe id") @PathVariable @Min(1) long id) {
		RecipeRead recipe = recipeFacade.getRecipeById(id);
		return ResponseEntity.status(HttpStatus.OK)
		                     .body(recipe);
	}


	@SearchRecipesWithRestrictionsApiAnnotation
	@GetMapping("/search")
	public ResponseEntity<List<RecipeRead>> searchRecipesWithRestrictions(
			@ApiParam(value = "Category of recipes sought") @RequestParam(required = false) Optional<String> category,
			@ApiParam(value = "Ingredients that must be included in recipes") @RequestParam(required = false) List<String> ingredients
	                                                                     ) {
		List<RecipeRead> recipes = recipeFacade.searchRecipes(category, ingredients);
		return Optional.ofNullable(recipes.isEmpty() ? null : recipes)
		               .map(ResponseEntity.status(HttpStatus.OK)::body)
		               .orElseGet(() -> ResponseEntity.status(HttpStatus.NO_CONTENT)
		                                              .build());
	}

	@ResponseStatus(
			value = HttpStatus.NOT_FOUND,
			reason = "Recipe not found"
	)
	@ExceptionHandler(RecipeNotFoundException.class)
	@SuppressWarnings("PMD.UncommentedEmptyMethodBody")
	public void handleRecipeNotFoundException() {
	}
}
