package recipes.recipe.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import recipes.recipe.Recipe;
import recipes.recipe.controller.annotation.*;
import recipes.recipe.exception.RecipeNotFoundException;
import recipes.recipe.model.RecipeCreate;
import recipes.recipe.model.RecipeRead;
import recipes.recipe.model.RecipeUpdate;
import recipes.recipe.service.exception.RecipeExceptionHandlerService;
import recipes.recipe.service.facade.RecipeFacade;
import recipes.user.exception.UserAuthorizationException;

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
	private final RecipeExceptionHandlerService exceptionService;

	@PostRecipeApiAnnotation
	@PostMapping("/new")
	public ResponseEntity<Recipe.ID> postRecipe(@Valid @RequestBody RecipeCreate recipeCreate) {
		return recipeFacade.postRecipe(recipeCreate);
	}

	@UpdateRecipeByIdApiAnnotation
	@PutMapping("/{id}")
	public ResponseEntity<String> updateRecipeById(
			@PathVariable @Min(1) long id, @RequestBody RecipeUpdate recipeUpdate
	                                              ) {
		recipeFacade.updateRecipeById(id, recipeUpdate);
		return ResponseEntity.status(HttpStatus.NO_CONTENT)
		                     .build();
	}

	@DeleteRecipeByIdApiAnnotation
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteRecipeById(@PathVariable @Min(1) long id) {
		recipeFacade.deleteRecipeById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT)
		                     .build();
	}

	@GetRecipeByIdApiAnnotation
	@GetMapping("/{id}")
	public ResponseEntity<RecipeRead> getRecipeById(@PathVariable @Min(1) long id) {
		RecipeRead recipe = recipeFacade.getRecipeById(id);
		return ResponseEntity.status(HttpStatus.OK)
		                     .body(recipe);
	}


	@SearchRecipesWithRestrictionsApiAnnotation
	@GetMapping("/search")
	public ResponseEntity<List<RecipeRead>> searchRecipesWithRestrictions(
			@RequestParam(required = false) Optional<String> category,
			@RequestParam(required = false) List<String> ingredients)
	{
		List<RecipeRead> recipes = recipeFacade.searchRecipes(category, ingredients);
		return Optional.ofNullable(recipes.isEmpty() ? null : recipes)
		               .map(ResponseEntity.status(HttpStatus.OK)::body)
		               .orElseGet(() -> ResponseEntity.status(HttpStatus.NO_CONTENT)
		                                              .build());
	}

	@ResponseStatus(
			value = HttpStatus.BAD_REQUEST,
			reason = "At least one field must be filled in to search for recipes"
	)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<String> recipeArgumentsValidationFail(MethodArgumentNotValidException e) {
		String message = exceptionService.getMethodArgumentsFailMessage(e);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
		                     .body(message);
	}

	@ResponseStatus(
			value = HttpStatus.NOT_FOUND,
			reason = "The recipe you are asking for does not exist"
	)
	@ExceptionHandler(RecipeNotFoundException.class)
	public ResponseEntity<String> recipeNotFound() {
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
		                     .body("The recipe you are asking for does not exist");
	}

	@ResponseStatus(
			value = HttpStatus.FORBIDDEN,
			reason = "You don't have permission to this recipe"
	)
	@ExceptionHandler(UserAuthorizationException.class)
	public ResponseEntity<String> permissionToRecipeDenied() {
		return ResponseEntity.status(HttpStatus.FORBIDDEN)
		                     .body("You don't have permission to this recipe");
	}

}
