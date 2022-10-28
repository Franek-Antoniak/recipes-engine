package recipes.recipe.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import recipes.recipe.Recipe;
import recipes.recipe.controller.swagger.PostRecipeApiAnnotation;
import recipes.recipe.exception.RecipeNotFoundException;
import recipes.recipe.exception.TooManyOrNotEnoughMethodArguments;
import recipes.recipe.facade.RecipeFacade;
import recipes.recipe.model.RecipeCreate;
import recipes.recipe.model.RecipeRead;
import recipes.recipe.model.RecipeUpdate;
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

	@PostRecipeApiAnnotation
	@PostMapping("/new")
	public ResponseEntity<Recipe.ID> postRecipe(@Valid @RequestBody RecipeCreate recipeCreate) {
		return recipeFacade.postRecipe(recipeCreate);
	}


	@PutMapping("/{id}")
	public ResponseEntity<String> updateRecipeById(@PathVariable @Min(1) long id,
			@Valid @RequestBody RecipeUpdate recipeUpdate) {
		return recipeFacade.updateRecipeById(id, recipeUpdate);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteRecipeById(@PathVariable @Min(1) long id) {
		return recipeFacade.deleteRecipeById(id);
	}

	@GetMapping("/{id}")
	public ResponseEntity<RecipeRead> getRecipeById(@PathVariable @Min(1) long id) {
		return recipeFacade.getRecipeById(id);
	}

	@GetMapping("/search")
	public List<RecipeRead> getAllRecipesCategoryOrNameRestriction(
			@RequestParam(required = false) Optional<String> category,
			@RequestParam(required = false) Optional<String> name) {
		return recipeFacade.getAllRecipesCategoryOrNameRestriction(category, name);
	}


	// Exceptions Handlers
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<String> userDetailsValidationFail(MethodArgumentNotValidException e) {
		StringBuilder stringBuilder = new StringBuilder();
		for (ObjectError error : e.getBindingResult()
		                          .getAllErrors()) {
			stringBuilder.append(error.getDefaultMessage())
			             .append("\n");
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
		                     .body(stringBuilder.toString());
	}

	@ResponseStatus(value = HttpStatus.NOT_FOUND, // 404 - NOT_FOUND
			reason = "The recipe you are asking for does not exist")
	@ExceptionHandler(RecipeNotFoundException.class)
	public void recipeNotFound() {
	}

	@ResponseStatus(value = HttpStatus.BAD_REQUEST, // 400 - BAD_REQUEST
			reason = "There is too many or not enough search arguments.")
	@ExceptionHandler(TooManyOrNotEnoughMethodArguments.class)
	public void wrongParams() {
	}

	@ResponseStatus(value = HttpStatus.FORBIDDEN, // 401 - BAD_REQUEST
			reason = "You don't have permission to this recipe")
	@ExceptionHandler(UserAuthorizationException.class)
	public void permissionToRecipeDenied() {
	}

}
