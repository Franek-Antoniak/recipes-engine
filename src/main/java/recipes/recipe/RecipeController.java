package recipes.recipe;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import recipes.recipe.exception.RecipeNotFoundException;
import recipes.recipe.exception.TooManyOrNotEnoughMethodArguments;
import recipes.recipe.model.RecipeCreate;
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

    // Endpoints without authentication

    @PostMapping("/new")
    public ResponseEntity<Recipe.ID> postRecipe(@Valid @RequestBody RecipeCreate recipeCreate) {
        return recipeFacade.postRecipe(recipeCreate);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getRecipeById(@PathVariable @Min(1) long id) {
        return recipeFacade.getRecipeById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRecipeById(@PathVariable @Min(1) long id) {
        return recipeFacade.deleteRecipeById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateRecipeById(@PathVariable @Min(1) long id,
                                                   @Valid @RequestBody RecipeUpdate recipeUpdate) {
        return recipeFacade.updateRecipeById(id, recipeUpdate);
    }

    @GetMapping("/search")
    public List<Recipe> getAllRecipesCategoryOrNameRestriction(
            @RequestParam(required = false) Optional<String> category,
            @RequestParam(required = false) Optional<String> name) {
        return recipeFacade.getAllRecipesCategoryOrNameRestriction(category, name);
    }

    // TODO: 30.06.2021 You probably need to make some kind of authorization - only author can delete or update
    //  recipe, if a user is not the author, the service should respond with 403(Forbidden)

    // FIXME: 30.06.2021 As i understand all the endpoints you created should stay as it is. You should only
    //  make new ones with authentications.

    // Endpoints with authentication


    // TODO: 30.06.2021

    // Exceptions Handlers

    @ResponseStatus(value = HttpStatus.NOT_FOUND, // 404 - NOT_FOUND
            reason = "The recipe you are asking for does not exist")
    @ExceptionHandler(RecipeNotFoundException.class)
    public void recipeNotFound() {
    }

    // FIXME: 29.06.2021 It's clearly confusing find a way to make it by validation
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

    // TODO: 28.06.2021 If you want to, you can make it in more detail
    //  - creating more exceptions and adds more handlers for them
}
