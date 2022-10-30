package recipes.recipe.controller.annotation;

import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import recipes.recipe.model.RecipeRead;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@ApiOperation(value = "Search recipes with restrictions")
@ResponseStatus(HttpStatus.OK)
@ApiResponses(
		value = {@ApiResponse(
				responseCode = "200",
				description = "Recipes found and returned",
				content = @Content(
						array = @ArraySchema(schema = @Schema(implementation = RecipeRead.class)),
						mediaType = "application/json"
				)
		), @ApiResponse(
				responseCode = "204",
				description = "No recipes found"
		)}
)
@Retention(RUNTIME)
@Target({METHOD, ANNOTATION_TYPE})
public @interface SearchRecipesWithRestrictionsApiAnnotation {
}
